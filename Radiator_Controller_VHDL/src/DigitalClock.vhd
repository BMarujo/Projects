library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity DigitalClock is
	port(CLOCK_50	: in std_logic;
		 SW			: in std_logic_vector(1 downto 0);
		 KEY		: in std_logic_vector(2 downto 0);
		 HEX0		: out std_logic_vector(6 downto 0);
		 HEX1		: out std_logic_vector(6 downto 0);
		 HEX2		: out std_logic_vector(6 downto 0);
		 HEX3		: out std_logic_vector(6 downto 0);
		 address	: out std_logic_vector(4 downto 0));
end DigitalClock;

architecture Behavioral of DigitalClock is

	-- enable signals

	signal globalEnable, setModeEnabled : std_logic;

	-- clock signals

	signal displayMinEnable, displayHourEnable : std_logic;

	-- debounced key signals

	signal s_setKey, s_plus, s_minus : std_logic;

	-- fsm set signal (2 bits)

	signal set : std_logic_vector(1 downto 0);

	-- counter signals

	signal s_minUnitBinary, s_minTenBinary: std_logic_vector(3 downto 0);
	signal s_hourUnitBinary, s_hourTenBinary: std_logic_vector(3 downto 0);

	signal s_minUnitTerm, s_minTenTerm: std_logic;
	signal s_hourUnitTerm, s_hourTenTerm: std_logic;

	signal s_minUnitEnable, s_minTenEnable: std_logic;
	signal s_hourUnitEnable, s_hourTenEnable: std_logic;

	signal s_minUnitDecrease, s_minTenDecrease: std_logic;
	signal s_hourUnitDecrease, s_hourTenDecrease: std_logic;

	signal s_hourUnitMax : natural := 9;

begin
	s_minus <= not KEY(0);
	s_plus <= not KEY(1);

	debouncerKey2 : entity work.debouncer(Behavioral)
		port map(refClk => CLOCK_50,
				dirtyIn => KEY(2),
				pulsedOut => s_setKey);

	setModeEnabled <= set(1) or set(0);

	-- pulse gen for HEX

	hexEnable: entity work.HexEnable(Behavioral)
		generic map(MAX		=> 50_000_000)
		port map(clk		=> CLOCK_50,
				 mode		=> set,
				 minEnable 	=> displayMinEnable,
				 hourEnable	=> displayHourEnable);
			
	-- fsm for setting the clock

	setClock: entity work.SetClock(Behavioral)
		port map(clk	=> CLOCK_50,
				 button	=> s_setKey,
				 output => set);

	-- pulse generator

	clkEnable : entity work.ClkEnable(Behavioral)
		port map(clk	=> CLOCK_50,
				mode	=> setModeEnabled,
				button	=> s_plus or s_minus,
				acel	=> SW(1 downto 0),
				enable	=> globalEnable);
	
	-- counters

	s_minUnitEnable <= (globalEnable and not setModeEnabled) or (set(0) and s_plus);
	s_minUnitDecrease <= (set(0) and s_minus);

	minUnit : entity work.Counter4Bits(Behavioral)
		port map(MAX    	=> 9,
				clk     	=> CLOCK_50,
				enable  	=> globalEnable,
				countUp   	=> s_minUnitEnable,
				countDown	=> s_minUnitDecrease,
				valOut  	=> s_minUnitBinary,
				tensEnable 	=> s_minUnitTerm);
	
	s_minTenEnable <= (s_minUnitTerm and s_minUnitEnable);
	s_minTenDecrease <= (s_minUnitDecrease and s_minUnitTerm);

	minTen : entity work.Counter4Bits(Behavioral)
		port map(MAX    => 5,
			clk     => CLOCK_50,
			enable  => globalEnable,
			countUp   => s_minTenEnable,
			countDown	=> s_minTenDecrease,
			valOut  => s_minTenBinary,
			tensEnable => s_minTenTerm);

	s_hourUnitEnable <= ((s_minTenTerm and s_minUnitTerm) and not setModeEnabled) or (set(1) and s_plus);
	s_hourUnitDecrease <= (set(1) and s_minus);

	s_hourUnitMax <= 3 when ((s_hourTenBinary = "0010") and (s_minus = '0')) else
					3 when ((s_hourTenBinary = "0000") and (s_minus = '1')) else
					9;

	hourUnit : entity work.Counter4Bits(Behavioral)
		port map(MAX    => s_hourUnitMax,
			clk     => CLOCK_50,
			enable  => globalEnable,
			countUp   => s_hourUnitEnable,
			countDown	=> s_hourUnitDecrease,
			valOut  => s_hourUnitBinary,
			tensEnable => s_hourUnitTerm);
	
	s_hourTenEnable <= (s_hourUnitTerm and s_hourUnitEnable);
	s_hourTenDecrease <= (s_hourUnitDecrease and s_hourUnitTerm);

	hourTen : entity work.Counter4Bits(Behavioral)
		port map(MAX    => 2,
			clk     => CLOCK_50,
			enable  => globalEnable,
			countUp   => s_hourTenEnable,
			countDown	=> s_hourTenDecrease,
			valOut  => s_hourTenBinary,
			tensEnable => open);

	-- hex displays

	minUnitDecod : entity work.Bin7SegDecoder(Behavioral)
		port map(enable		=> displayMinEnable,
				binInput	=> s_minUnitBinary,
				decOut_n	=> HEX0);

	minTenDecod : entity work.Bin7SegDecoder(Behavioral)
		port map(enable		=> displayMinEnable,
				binInput	=> s_minTenBinary,
				decOut_n	=> HEX1);

	hourUnitDecod : entity work.Bin7SegDecoder(Behavioral)
		port map(enable		=> displayHourEnable,
				binInput	=> s_hourUnitBinary,
				decOut_n	=> HEX2);

	hourTenDecod : entity work.Bin7SegDecoder(Behavioral)
		port map(enable		=> displayHourEnable,
				binInput	=> s_hourTenBinary,
				decOut_n	=> HEX3);

	-- join hours (for use with the rom component)

	hourJoin : entity work.Hour_join(Behavioral)
		port map(dezenas	=> s_hourTenBinary,
				 unidades	=> s_hourUnitBinary,
				 endereco	=> address);
	
end Behavioral;
