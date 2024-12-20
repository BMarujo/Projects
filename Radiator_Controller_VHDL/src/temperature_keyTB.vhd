library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;


entity temperature_keyTB is
end temperature_keyTB;



architecture Stimulus of temperature_keyTB is
	
    signal s_state: std_logic_vector(1 downto 0);
    signal s_clock: std_logic;
    signal s_button : STD_LOGIC_VECTOR(2 downto 0);


    signal s_Tsol : std_logic_vector(8 downto 0);
    signal s_Tlua : std_logic_vector(8 downto 0);
    signal s_Tgel : std_logic_vector(8 downto 0);
    signal s_dezenas : std_logic_vector(3 downto 0);
    signal s_unidades : std_logic_vector (3 downto 0);
    signal s_decimas: std_logic_vector(3 downto 0);
    signal s_secondlight : std_logic_vector(8 downto 7);
    signal s_light   : std_logic_vector(17 downto 1);


begin

	uut: entity work.temperature_key(Behavioral)
			port map (state => s_state,
				        clock=> s_clock,
                        button=> s_button,
                        Tsol=>s_Tsol,
                        Tlua=> s_Tlua,
                        Tgel=> s_Tgel,
						dezenas => s_dezenas,
                        unidades=>s_unidades,
                        decimas=>s_decimas,
                        light=>s_light,
                        secondlight=>s_secondlight);
						
	
	stim_proc : process
	
	
	begin
		s_state <= "01";
        s_clock <= '0';
		wait for 2 ns;
		s_clock <='1';
		wait for 2 ns;
        s_button <="010";
        wait for 2 ns;
	
	end process;
	
end Stimulus;