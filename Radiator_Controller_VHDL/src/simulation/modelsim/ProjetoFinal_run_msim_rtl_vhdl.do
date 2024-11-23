transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vcom -93 -work work {C:/LECI/LSD/ControloRadiador-LSD/Debouncer.vhd}
vcom -93 -work work {C:/LECI/LSD/ControloRadiador-LSD/temperature_key.vhd}

