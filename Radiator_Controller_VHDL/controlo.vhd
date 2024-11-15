library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity controlo is

	generic(histerese: std_logic_vector(3 downto 0) :="1101");
	port(Tref: in std_logic_vector(8 downto 0);
			Tamb: in std_logic_vector(8 downto 0);
			clk: in std_logic;
			rad: out std_logic);
end controlo;

architecture Behavioral of controlo is

begin 
	process(clk)	
	begin
	
		if rising_edge(clk) then
		
			if (Tamb > std_logic_vector(unsigned(Tref)+unsigned(histerese))) then
				rad <= '0';	
				if (Tamb = Tref) then
					rad <='0';
				elsif(Tamb = std_logic_vector(unsigned(Tref)-unsigned(histerese))) then
					rad<='1';
				end if;
				
			elsif (Tamb < std_logic_vector(unsigned(Tref)-unsigned(histerese))) then
					rad <='1';
				if (Tamb = Tref) then
					rad <='1';
				elsif(Tamb = std_logic_vector(unsigned(Tref)+unsigned(histerese))) then
					rad<='0';
				end if;
				
			end if;
		end if;
	end process;
end Behavioral;