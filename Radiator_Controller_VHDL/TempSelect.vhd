library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity TempSelect is
    port(Tsol   : in std_logic_vector(8 downto 0);
        Tlua    : in std_logic_vector(8 downto 0);
        Tgel    : in std_logic_vector(8 downto 0);
        Sel     : in  std_logic_vector(1 downto 0);
        light   : out std_logic_vector(6 downto 0);
        Tref    : out std_logic_vector(8 downto 0));
end TempSelect;

architecture Behavioral of TempSelect is
begin
    process (Sel, Tsol, Tlua, Tgel)
    begin
        case Sel is
            when "00" =>
                Tref <= Tsol;
					 light(6)<='1';
					 light(3)<='0';
					 light(0)<='0';
					 
            when "01" =>
                Tref <= Tlua;
					 light(6)<='0';
					 light(3)<='1';
					 light(0)<='0';
            when "10" =>
                Tref <= Tgel;
					 light(6)<='0';
					 light(3)<='0';
					 light(0)<='1';
            when others =>
                Tref <= (others=>'0');  -- valor default
        end case;
    end process;
end Behavioral;