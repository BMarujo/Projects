library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity Rom_tempTB is 
end Rom_tempTB; 

architecture Stimulus of Rom_tempTB is
	signal s_address: std_logic_vector(4 downto 0);
	signal s_dataOut: std_logic_vector(1 downto 0);
begin

	uut: entity work.Rom_temp(Behavioral)
			port map (address => s_address,
						dataOut=> s_dataOut);
						
	stim_proc : process
	begin
		s_address <= "10000"; 
		
		wait for 100 ns;
		s_address <= "00000"; 
		
		wait for 100 ns;
		s_address <= "00111"; 
		
		wait for 100 ns;
		s_address <= "10111"; 
		wait for 100 ns;
	end process;
	
end Stimulus;
	