library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity DisplaySelector is
	port(HexIn1 : in std_logic_vector(6 downto 0);
		 HexIn2 : in std_logic_vector(6 downto 0);
		 mode   : in  std_logic_vector(1 downto 0); 
         HexOut : out std_logic_vector(6 downto 0));
end DisplaySelector;

architecture Behavioral of DisplaySelector is
begin
	process(mode)
	begin
		if( mode = "00") then
			HexOut <= HexIn1;
		else
			HexOut <= HexIn2;
		end if;
	end process;
end Behavioral;