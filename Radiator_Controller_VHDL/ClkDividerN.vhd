library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity ClkDividerN is
	generic(divFactor	: natural := 1_250_000_000);
	port(clkIn	: in  std_logic;
		mode	: in std_logic_vector(1 downto 0);
		SW	: in std_logic_vector(1 downto 0);
		clkOut	: out std_logic);
end ClkDividerN;

architecture Behavioral of ClkDividerN is

	signal s_divCounter : natural;
	signal s_divFactor : natural := divFactor;

begin	
	process(clkIn)
	begin
		if (mode = "00") then
			case SW is
				when "01" =>
					s_divFactor <= divFactor/60;
				when "10" =>
					s_divFactor <= divFactor/600;
				when "11" =>
					s_divFactor <= divFactor/3600;
				when others =>
					s_divFactor <= divFactor;
			end case;
		end if;

		if (rising_edge(clkIn)) then
			if (s_divCounter = s_divFactor - 1) then
				clkOut		 <= '0';
				s_divCounter <= 0;
			elsif (s_divCounter > s_divFactor - 1) then
				s_divCounter <= 0;
			else
				if (s_divCounter = (s_divFactor / 2 - 1)) then
					clkOut	 <= '1';
				end if;
				s_divCounter <= s_divCounter + 1;
			end if;
		end if;
	end process;
end Behavioral;
