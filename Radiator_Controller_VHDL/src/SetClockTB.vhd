library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity SetClockTB is 
end SetClockTB; 

architecture Stimulus of SetClockTB is
	signal s_clk: std_logic;
	signal s_button: std_logic;
	
	signal s_output:std_logic_vector(1 downto 0);
begin

	uut: entity work.SetClock(Behavioral)
			port map (clk => s_clk,
						button=> s_button,
						output => s_output);
						
	clk_proc : process
	begin
		s_clk <= '1';
		wait for 1000000000 ns;
		s_clk <='0';
		wait for 500000000 ns;
	end process;
	
	stim_proc : process
	begin
		s_button <= '1'; 
		
		wait for 2000000000 ns;
		s_button <= '0'; 
		
		wait for 2000000000 ns;
		s_button <= '1'; 
		
		wait for 2000000000 ns;
		s_button <= '0'; 
		wait for 2000000000 ns;
	end process;
	
end Stimulus;
	