library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity Rom_temp is
	port(address : in std_logic_vector(4 downto 0);
		  dataOut : out std_logic_vector(1 downto 0));
end Rom_temp;

architecture Behavioral of Rom_temp is
	subtype TDataWord is std_logic_vector(1 downto 0);
	type TROM is array (0 to 23) of TDataWord;
	constant c_memory: TROM := ("10", "10", "10", "10",
										 "10", "01", "01",
										 "00", "00", "00", "00",
										 "00", "00", "00", "00","00","00","00","01","01","10","10","10","10");
begin
	dataOut <= c_memory(to_integer(unsigned(address)));
end Behavioral;