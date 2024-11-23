library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity temperature_counterTB is
end temperature_counterTB;


architecture Stimulus of temperature_counterTB is
	
    signal s_rad: std_logic;
    signal s_clk: std_logic;

    signal s_dezenas : std_logic_vector(3 downto 0);
    signal s_unidades : std_logic_vector (3 downto 0);
    signal s_decimas: std_logic_vector(3 downto 0);
    signal s_count:  std_logic_vector(8 downto 0);


begin

	uut: entity work.temperature_counter(Behavioral)
			port map (rad => s_rad,
				        clk=> s_clk,
						dezenas => s_dezenas,
                        unidades=>s_unidades,
                        decimas=>s_decimas,
                        count=>s_count);
						
	
	stim_proc : process
	
	
	begin
		
		s_rad <= '0'; 
        s_clk <='0';
		
		wait for 2 ns;
		
        s_rad <= '1'; 
        s_clk <= '1';
		
		wait for 2 ns;
        
        s_rad <='1';
	
	end process;
	
end Stimulus;