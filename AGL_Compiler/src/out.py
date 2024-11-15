import tkinter as tk
from tkinter import *
import time
from agl_library import *

#            x
#   --------->
#   |
#   |
#   |
#   |
#   |
# y v


root = tk.Tk()
root.withdraw()  # Oculta a janela principal
top = tk.Toplevel()

view=View(top, width=401,height=401,title="Illustrating the rectangle shape",background="wheat",)
Rectangle((10,0), length=((200,60)),fill="blue",)
view.add(Rectangle((10,0), length=((200,60)),fill="blue",))

pacman = PieSlice((0,0), length=((50,50)),fill="pink",start=30,extent=300,)

view.add(pacman)

view.refresh()
for i in range(1, 10):
    pacman.start=1,
    pacman.extent=359,
    view.refresh(time=0.02)
    pacman.start=30,
    pacman.extent=300,
    view.refresh(time=0.025)
    pacman.move((10,0))
    view.move((10,0))
    view.refresh()
print("Press any mouse button to quit")
pos = ClickListener().wait_for_click()
view.close()
