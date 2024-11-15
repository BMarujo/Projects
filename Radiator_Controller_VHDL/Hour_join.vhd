library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;


entity Hour_join is
	generic(N: std_logic_vector(3 downto 0) :="1010");

	port(dezenas: in std_logic_vector(3 downto 0);
			unidades: in std_logic_vector(3 downto 0);
			endereco: out std_logic_vector(4 downto 0));
			
end Hour_join;


architecture Behavioral of Hour_join is

signal dezenas2 : std_logic_vector(7 downto 0);
signal soma: unsigned(7 downto 0);

begin 
	dezenas2 <= std_logic_vector(unsigned(dezenas) * unsigned(N));

	process(dezenas, unidades,dezenas2)
	begin
	soma<= (unsigned(dezenas2) + unsigned(unidades));
	endereco <= std_logic_vector(unsigned(soma(4 downto 0)));
	
	end process;

end Behavioral;

