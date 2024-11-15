library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity ControloRadiador is 
	port(CLOCK_50 :  in  std_logic;
		KEY :  in  std_logic_vector(3 downto 0);
		SW :  in  std_logic_vector(1 downto 0);
		HEX0 :  out  std_logic_vector(6 downto 0);
		HEX1 :  out  std_logic_vector(6 downto 0);
		HEX2 :  out  std_logic_vector(6 downto 0);
		HEX3 :  out  std_logic_vector(6 downto 0);
		HEX4 :  out  std_logic_vector(6 downto 0);
		HEX5 :  out  std_logic_vector(6 downto 0);
		HEX6 :  out  std_logic_vector(6 downto 0);
		HEX7 :  out  std_logic_vector(6 downto 0);
		LEDG :  out  std_logic_vector(8 downto 0);
		LEDR :  out  std_logic_vector(17 downto 0));
end ControloRadiador;

architecture Shell of ControloRadiador is

	signal	debouncedKey3 :  std_logic;

	signal	s_radEnableLight :  std_logic;

	signal	s_clockOutTemp :  std_logic;
	signal	s_currentSetTemp :  std_logic_vector(1 downto 0);
	signal	s_activeTemp :  std_logic_vector(1 downto 0);

	signal	s_romAddress :  std_logic_vector(4 downto 0);
	
	signal	tAmb :  std_logic_vector(8 downto 0);
	signal	tGel :  std_logic_vector(8 downto 0);
	signal	tLua :  std_logic_vector(8 downto 0);
	signal	tSol :  std_logic_vector(8 downto 0);
	signal	tRef :  std_logic_vector(8 downto 0);

	signal	s_tAmb_Ten :  std_logic_vector(3 downto 0);
	signal	s_tAmb_Units :  std_logic_vector(3 downto 0);
	signal	s_tAmb_Tenths :  std_logic_vector(3 downto 0);

	signal	s_tAmb_TenHex :  std_logic_vector(6 downto 0);
	signal	s_tAmb_UnitsHex :  std_logic_vector(6 downto 0);
	signal	s_tAmb_TenthsHex :  std_logic_vector(6 downto 0);
	
	signal	s_setTemp_Ten :  std_logic_vector(3 downto 0);
	signal	s_setTemp_Units :  std_logic_vector(3 downto 0);
	signal	s_setTemp_Tenths :  std_logic_vector(3 downto 0);

	signal	setTemp_TenHex :  std_logic_vector(6 downto 0);
	signal	setTemp_UnitsHex :  std_logic_vector(6 downto 0);
	signal	setTemp_TenthsHex :  std_logic_vector(6 downto 0);
	
begin 
	
	-- Responsible for the degree symbol in the 4th HEX

	HEX4 <= "0011100";

	-- Responsible for the radiator on/off light

	LEDR(0) <= s_radEnableLight;

	-- Debouncer

	debouncerKey3 : entity work.debouncer(Behavioral)
		port map(refClk => CLOCK_50,
				dirtyIn => KEY(3),
				pulsedOut => debouncedKey3);

	-- HEX displays

	setTemp_Ten : entity work.bin7segdecoder(Behavioral)
		port map(enable => '1',
			binInput => s_setTemp_Ten,
			decOut_n => setTemp_TenHex);
			
	setTemp_Units : entity work.bin7segdecoder(Behavioral)
		port map(enable => '1',
			binInput => s_setTemp_Units,
			decOut_n => setTemp_UnitsHex);
				
	setTemp_Tenths : entity work.bin7segdecoder(Behavioral)
		port map(enable => '1',
			binInput => s_setTemp_Tenths,
			decOut_n => setTemp_TenthsHex);

	tAmb_Ten : entity work.bin7segdecoder(Behavioral)
		port map(enable => '1',
			binInput => s_tAmb_Ten,
			decOut_n => s_tAmb_TenHex);
					
	tAmb_Units : entity work.bin7segdecoder(Behavioral)
		port map(enable => '1',
				binInput => s_tAmb_Units,
				decOut_n => s_tAmb_UnitsHex);
	
	tAmb_Tenths : entity work.bin7segdecoder(Behavioral)
		port map(enable => '1',
				binInput => s_tAmb_Tenths,
				decOut_n => s_tAmb_TenthsHex);
	
	-- Select display

	setTempTenHex : entity work.displayselector(Behavioral)
		port map(HexIn1 => s_tAmb_TenHex,
				HexIn2 => setTemp_TenHex,
				mode => s_currentSetTemp,
				HexOut => HEX7);

	setTempUnitsHex : entity work.displayselector(Behavioral)
		port map(HexIn1 => s_tAmb_UnitsHex,
				HexIn2 => setTemp_UnitsHex,
				mode => s_currentSetTemp,
				HexOut => HEX6);


	setTempTenthsHex : entity work.displayselector(Behavioral)
		port map(HexIn1 => s_tAmb_TenthsHex,
				HexIn2 => setTemp_TenthsHex,
				mode => s_currentSetTemp,
				HexOut => HEX5);

	-- Temperature related

	ambientSimulator : entity work.temperature_counter(Behavioral)
		port map(rad => s_radEnableLight,
			clk => s_clockOutTemp,
			count => tAmb,
			decimas => s_tAmb_Tenths,
			dezenas => s_tAmb_Ten,
			unidades => s_tAmb_Units);
		
	setTempFSM : entity work.settemperature(Behavioral)
		port map(clk => CLOCK_50,
				button => debouncedKey3,
				output => s_currentSetTemp);
				
	setTemps : entity work.temperature_key(Behavioral)
		port map(clock => CLOCK_50,
				light(17) => LEDR(17),
				light(14) => LEDR(14),
				light(11) => LEDR(11),
				secondlight(8)=>LEDG(8),
				button => KEY(2 downto 0),
				state => s_currentSetTemp,
				decimas => s_setTemp_Tenths,
				dezenas => s_setTemp_Ten,
				Tgel => tGel,
				Tlua => tLua,
				Tsol => tSol,
				unidades => s_setTemp_Units);

	selectTemp_Lights : entity work.tempselect(Behavioral)
		port map(Sel => s_activeTemp,
				Tgel => tGel,
				Tlua => tLua,
				Tsol => tSol,
				light => LEDG(6 downto 0),
				Tref => tRef);
	
	-- ROM for the schedule

	romSchedule : entity work.rom_temp(Behavioral)
		port map(address => s_romAddress,
				dataOut => s_activeTemp);

	-- Clock divider for temperature related entities

	clockDivider : entity work.clkdividern(Behavioral)
		port map(clkIn => CLOCK_50,
				mode => s_currentSetTemp,
				SW => SW,
				clkOut => s_clockOutTemp);

	-- Clock related

	digitalClock : entity work.digitalclock(Behavioral)
		port map(CLOCK_50 => CLOCK_50,
				KEY => KEY(2 downto 0),
				SW => SW,
				address => s_romAddress,
				HEX0 => HEX0,
				HEX1 => HEX1,
				HEX2 => HEX2,
				HEX3 => HEX3);
	
	-- Radiator Control (with hysteresis)

	remoteOnOff : entity work.controlo(Behavioral)
		generic map(histerese => "1101")
		port map(Tref => tRef,
				Tamb => tAmb,
				clk => s_clockOutTemp,
				rad => s_radEnableLight);

end Shell;