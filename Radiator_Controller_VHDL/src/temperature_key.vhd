library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;


entity temperature_key is
    Port ( state : in std_logic_vector(1 downto 0);
			  clock : in std_logic;
           button : in STD_LOGIC_VECTOR(2 downto 0);
			  Tsol   : out std_logic_vector(8 downto 0);
			  Tlua    : out std_logic_vector(8 downto 0);
			  Tgel    : out std_logic_vector(8 downto 0);
			  dezenas : out std_logic_vector(3 downto 0);
			  unidades : out std_logic_vector (3 downto 0);
			  decimas: out std_logic_vector(3 downto 0);
			  secondlight : out std_logic_vector(8 downto 7);
			  light   : out std_logic_vector(17 downto 1));
end temperature_key;

architecture Behavioral of temperature_key is

	signal s_Tsol: unsigned (8 downto 0) := "011001000";
	signal s_Tlua: unsigned (8 downto 0) := "010100000";
	signal s_Tgel: unsigned (8 downto 0) := "000101000";
	signal s_dezenas :unsigned (8 downto 0);
	signal s_unidades :unsigned (8 downto 0);
	signal s_decimas :unsigned (8 downto 0);

	signal s_plus, s_minus : std_logic;
    
begin

	debouncedKey1: entity work.Debouncer(Behavioral)
		generic map(outPolarity	=> '0')
		port map(refClk			=> clock,
				 dirtyIn		=> button(1),
				 pulsedOut		=> s_plus);

	debouncedKey0: entity work.Debouncer(Behavioral)
		generic map(outPolarity	=> '0')
		port map(refClk			=> clock,
				 dirtyIn		=> button(0),
				 pulsedOut		=> s_minus);

	process (clock)
	
	begin
	
	
	if (rising_edge(clock)) then
	
	
	
		if (state = "01") then

			light(17)<='1';
			light(14)<='0';
			light(11)<='0';
			secondlight(8)<='1';
					
			if s_plus='0' then
			
			
				s_Tsol <= s_Tsol + 1;


			elsif s_minus='0' then 
			
				s_Tsol <= s_Tsol - 1;
				
			end if;
				
			s_dezenas <= (unsigned(s_Tsol) / 100);
			s_unidades <= (unsigned(s_Tsol) rem 100)/10;
			s_decimas <= (unsigned(s_Tsol) rem 10);
			
			dezenas <= std_logic_vector(s_dezenas(3 downto 0));
			unidades <= std_logic_vector(s_unidades(3 downto 0));
			decimas <= std_logic_vector(s_decimas(3 downto 0));
		
		
		elsif (state="10") then

			light(17)<='0';
			light(14)<='1';
			light(11)<='0';
			secondlight(8)<='1';
		
				
			if s_plus='0' then
			
				s_Tlua <= s_Tlua + 1;



			elsif s_minus='0' then 
			
				s_Tlua <= s_Tlua - 1;
				
			end if;
				
			s_dezenas <= (unsigned(s_Tlua) / 100);
			s_unidades <= (unsigned(s_Tlua) rem 100)/10;
			s_decimas <= (unsigned(s_Tlua) rem 10);
			
			dezenas <= std_logic_vector(s_dezenas(3 downto 0));
			unidades <= std_logic_vector(s_unidades(3 downto 0));
			decimas <= std_logic_vector(s_decimas(3 downto 0));
		
		
		elsif (state = "11") then

			light(17)<='0';
			light(14)<='0';
			light(11)<='1';
			secondlight(8)<='1';
		
				
				
			if s_plus='0' then
			
				s_Tgel <= s_Tgel + 1;


			elsif s_minus='0' then 
			
			
				s_Tgel <= s_Tgel - 1;
				
			end if;
				
			s_dezenas <= (unsigned(s_Tgel) / 100);
			s_unidades <= (unsigned(s_Tgel) rem 100)/10;
			s_decimas <= (unsigned(s_Tgel) rem 10);
			
			dezenas <= std_logic_vector(s_dezenas(3 downto 0));
			unidades <= std_logic_vector(s_unidades(3 downto 0));
			decimas <= std_logic_vector(s_decimas(3 downto 0));
			
		else 
			
			light(17)<='0';
			light(14)<='0';
			light(11)<='0';
			secondlight(8)<='0';

		end if;
		
	end if;
	 
 
	end process;
	
	
		
	 Tsol <= std_logic_vector(s_Tsol);
	 Tlua <= std_logic_vector(s_Tlua);
	 Tgel <= std_logic_vector(s_Tgel);
 
 
 
 
 
end Behavioral;