library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity SetTemperature is
    Port ( clk : in STD_LOGIC;
           button : in STD_LOGIC;
           output : out STD_LOGIC_VECTOR (1 downto 0));
end SetTemperature;

architecture Behavioral of SetTemperature is
    type state_type is (normal, set_tsol, set_tlua, set_tgel);
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
                next_state <= set_tsol;
            when set_tsol =>
                output <= "01";
                next_state <= set_tlua;
            when set_tlua =>
                output <= "10";
                next_state <= set_tgel;
				when set_tgel =>
                output <= "11";
                next_state <= normal;		 
        end case;
    end process;
end Behavioral;