library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity Hour_joinTB is 
end Hour_joinTB; 

architecture Stimulus of Hour_joinTB is
	
    signal s_dezenas: std_logic_vector(3 downto 0);
    signal s_unidades: std_logic_vector(3 downto 0);

    signal s_endereco: std_logic_vector(4 downto 0);


begin

	uut: entity work.Hour_join(Behavioral)
			port map (dezenas => s_dezenas,
				        unidades=> s_unidades,
						endereco => s_endereco);
						
	
	stim_proc : process
	
	
	begin
	
		wait for 2 ns;
		
		s_dezenas <= "0010"; 
        s_unidades <="1000";
		
		wait for 2 ns;
		
        s_dezenas <= "0011"; 
        s_unidades <= "1001";
		
		wait for 2 ns;
	
	end process;
	
end Stimulus;
	