library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity SetClock is
    Port ( clk : in STD_LOGIC;
           button : in STD_LOGIC;
           output : out STD_LOGIC_VECTOR (1 downto 0));
end SetClock;

architecture Behavioral of SetClock is
    type state_type is (normal, set_h, set_m);
    signal current_state, next_state : state_type;
    signal button_prev : STD_LOGIC := '0';
begin
    process (clk, button)
    begin
        if rising_edge(clk) then
            if button = '1' and button_prev = '0' then
                current_state <= next_state;
            end if;
            button_prev <= button;
        end if;
    end process;

    process (current_state)
    begin
        case current_state is
            when normal =>
                output <= "00";
                next_state <= set_h;
            when set_h =>
                output <= "10";
                next_state <= set_m;
            when set_m =>
                output <= "01";
                next_state <= normal;
        end case;
    end process;
end Behavioral;