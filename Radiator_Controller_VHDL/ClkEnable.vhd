library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity ClkEnable is
	port(clk		: in std_logic;
		mode		: in std_logic;
		button		: in std_logic;
		acel		: in std_logic_vector(1 downto 0);
		enable		: out std_logic);
end ClkEnable;

architecture Behavioral of ClkEnable is

	signal seconds : natural := 0;

	signal s_count : unsigned(31 downto 0) := (others => '0');
    signal mode_prev : std_logic := '0';
	signal speed : unsigned(31 downto 0) := to_unsigned(3_000_000_000, 32);

begin
	process(clk, button, acel)
	begin
		if (rising_edge(clk)) then
			if (mode = '1') then
				if (button = '1') then
					if (mode = '1') and (seconds >= 2) then
						speed <= to_unsigned(5_000_000, 32);
					elsif (mode = '1') then
						enable <= '1';
						speed <= to_unsigned(50_000_000, 32);
					end if;
				else
					seconds <= 0;
				end	if;
            else
                case acel is
                    when "01" =>
                        speed <= to_unsigned(50_000_000, 32);
                    when "10" =>
                        speed <= to_unsigned(5_000_000, 32);
                    when "11" =>
                        speed <= to_unsigned((50_000_000/60), 32);
                    when others =>
                        speed <= to_unsigned((3_000_000_000), 32);
                end case;
			end if;

			enable <= '0';
			s_count <= s_count + 1;
			if (s_count = speed-1) or (s_count > speed-1) or ((button = '1') and (mode = '1') and (seconds < 1)) then
				s_count <= (others => '0');
				enable <= '1';
				seconds <= seconds + 1;
			end if;

			if mode = '1' and mode_prev = '0' then
				s_count <= (others => '0');
			end if;
			mode_prev <= mode;
		end if;
	end process;
end Behavioral;