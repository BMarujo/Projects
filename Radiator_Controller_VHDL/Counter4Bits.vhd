library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity Counter4Bits is
	port(MAX		: natural := 9;
		  clk		: in  std_logic;
		  enable	: in  std_logic;
		  countUp	: in  std_logic;
		  countDown	: in  std_logic;
		  valOut	: out std_logic_vector(3 downto 0);
		  tensEnable	: out std_logic);
end Counter4Bits;

architecture Behavioral of Counter4Bits is

	signal s_value : unsigned(3 downto 0);

begin
	process(clk)
	begin
		if (rising_edge(clk)) then
			if ((enable = '1') and (countUp = '1')) then
				if (to_integer(s_value) = MAX) then
					s_value <= (others => '0');
					tensEnable <= '0';
				else
					s_value <= s_value + 1;
					if (to_integer(s_value) = MAX - 1) then
						tensEnable <= '1';
					else
						tensEnable <= '0';
					end if;
				end if;
			elsif ((enable = '1') and (countDown = '1')) then
				if (to_integer(s_value) = 0) then
					s_value <= to_unsigned(MAX, s_value'length);
					tensEnable <= '0';
				else
					s_value <= s_value - 1;
					if (to_integer(s_value) = 1) then
						tensEnable <= '1';
					else
						tensEnable <= '0';
					end if;
				end if;
			end if;
		end if;
	end process;

	valOut <= std_logic_vector(s_value);
end Behavioral;
