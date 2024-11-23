library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity HexEnable is
	generic(MAX 	: natural := 50_000_000);
	port(clk		: in std_logic;
        mode        : in std_logic_vector(1 downto 0);
		minEnable	: out std_logic := '1';
        hourEnable  : out std_logic := '1');
end HexEnable;

architecture Behavioral of HexEnable is

	signal s_count : natural range 0 to MAX-1 := 0;
    signal s_min, s_hour : std_logic := '0';

begin
    
    process(clk)
    begin
        if rising_edge(clk) then
            if (mode = "00") or (s_count >= MAX-1) then
                s_count <= 0;
            else
                s_count <= s_count + 1;
            end if;

            if (mode = "01") then
                if (s_count >= (MAX/2)) then
                    minEnable <= '1';
                    hourEnable <= '1';
                else
                    minEnable <= '0';
                    hourEnable <= '1';
                end if;
            elsif (mode = "10") then
                if (s_count >= (MAX/2)) then
                    hourEnable <= '1';
                    minEnable <= '1';
                else
                    hourEnable <= '0';
                    minEnable <= '1';
                end if;
            else
                minEnable <= '1';
                hourEnable <= '1';
            end if;
        end if;
	end process;
end Behavioral;