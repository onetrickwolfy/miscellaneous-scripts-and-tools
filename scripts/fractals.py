#!/usr/bin/python
# Quick programming challenge done for bonus points.
# I decided to use turtle as I was tired of java.

from math import sqrt
from turtle import *

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    # overloading the + operator
    def __add__(self, point):
        return Point(self.x + point.x, self.y + point.y)
    
    # overloading the - operator
    def __sub__(self, point):
        return Point(self.x - point.x, self.y - point.y)
    
    # distance between self and another point
    # making you of the __sub__ overload
    def distance(self, point):
        point_diff = point - self
        return sqrt((point_diff.x)**2 + (point_diff.y)**2)
    
    # translates a point upward by {distance}
    def up(self, distance):
        return Point(self.x, distance + self.y)
    
    # translates a point backward by {distance}
    def down(self, distance):
        return Point(self.x, -distance+ self.y)
    
    # translates a point to the left by {distance}
    def left(self, distance):
        return Point(-distance + self.x, self.y)
    
    # translates a point to the right by {distance}
    def right(self, distance):
        return Point(distance + self.x, self.y)


# --------------------------------------------------
# -------------------- SET-UP ----------------------
# --------------------------------------------------

# Variables / Constants.
pointer = Turtle();
origine = Point(-200, -210)
n = 5
square_side_side = 460

# Setting up the screen.
def setup_turtle():
    screen = pointer.getscreen();
    screen.setup(width = 1000,height=900, startx = None, starty = None) 
    pointer.speed(0)
    pointer.hideturtle()
    screen.delay(0)
    pointer.speed(0)


# --------------------------------------------------
# ------------------ Functions ---------------------
# --------------------------------------------------

# Traces a segment
def segment(pointStart, pointEnd):
    pointer.penup()
    pointer.setpos(pointStart.x, pointStart.y)
    pointer.pendown()
    pointer.goto(pointEnd.x, pointEnd .y)

# Fractal line right to left.
def pattern_right(p_start, p_end, n):
    if n == 0: 
        segment(p_start, p_end)
        return

    distance = p_start.distance(p_end) / 4 
    
    # Add more steps to grow the pattern.
    step_1 = p_start.right(distance)
    step_2 = step_1.up(distance)
    step_3 = step_2.right(distance)
    step_4 = step_3.down(distance)
    step_5 = step_4.right(distance*2)
    
    # if n == 1 then we can trace the segment.
    # this condition is not "necessary"
    # removing it would add a bunch more lines 
    # though the fractal would be the exact same.
    if n > 1:
        pattern_right(p_start, step_1, n-1)
        pattern_up(step_1, step_2, n-1)
        pattern_right(step_2, step_3, n-1)
        pattern_down(step_3, step_4, n-1) 
        pattern_right(step_4, step_5, n-1) 
    else: 
        segment(p_start, step_1)
        segment(step_1, step_2)
        segment(step_2, step_3)
        segment(step_3, step_4)
        segment(step_4, step_5)

# Fractal line going up.
def pattern_up(p_start, p_end, n):
    if n == 0: 
        segment(p_start, p_end)
        return
    
    distance = p_start.distance(p_end) / 4 
    
    # Add more steps to grow the pattern.
    step_1 = p_start.up(distance)
    step_2 = step_1.left(distance)
    step_3 = step_2.up(distance)
    step_4 = step_3.right(distance)
    step_5 = step_4.up(distance*2)

    # if n == 1 then we can trace the segment.
    # this condition is not "necessary"
    # removing it would add a bunch more lines 
    # though the fractal would be the exact same.
    if n > 1:     
        pattern_up(p_start, step_1, n-1) 
        pattern_left(step_1, step_2, n-1) 
        pattern_up(step_2, step_3, n-1) 
        pattern_right(step_3, step_4, n-1)
        pattern_up(step_4, step_5, n-1) 
    else:
        segment(p_start, step_1)
        segment(step_1, step_2)
        segment(step_2, step_3)
        segment(step_3, step_4)
        segment(step_4, step_5)

# Fractal line going down.
def pattern_down(p_start, p_end, n):
    if n == 0: 
        segment(p_start, p_end)
        return
    
    distance = p_start.distance(p_end) / 4 
    
    # Add more steps to grow the pattern.
    step_1 = p_start.down(distance)
    step_2 = step_1.right(distance)
    step_3 = step_2.down(distance)
    step_4 = step_3.left(distance)
    step_5 = step_4.down(distance*2)

    # if n == 1 then we can trace the segment.
    # this condition is not "necessary"
    # removing it would add a bunch more lines 
    # though the fractal would be the exact same.
    if n > 1:     
        pattern_down(p_start, step_1, n-1) 
        pattern_right(step_1, step_2, n-1) 
        pattern_down(step_2, step_3, n-1) 
        pattern_left(step_3, step_4, n-1)
        pattern_down(step_4, step_5, n-1) 
    else:
        segment(p_start, step_1)
        segment(step_1, step_2)
        segment(step_2, step_3)
        segment(step_3, step_4)
        segment(step_4, step_5)

# Fractal line right to left.
def pattern_left(p_start, p_end, n):
    if n == 0: 
        segment(p_start, p_end)
        return
    
    distance = p_start.distance(p_end) / 4 
    
    # Add more steps to grow the pattern.
    step_1 = p_start.left(distance)
    step_2 = step_1.down(distance)
    step_3 = step_2.left(distance)
    step_4 = step_3.up(distance)
    step_5 = step_4.left(distance*2)

    # if n == 1 then we can trace the segment.
    # this condition is not "necessary"
    # removing it would add a bunch more lines 
    # though the fractal would be the exact same.
    if n > 1:     
        pattern_left(p_start, step_1, n-1)
        pattern_down(step_1, step_2, n-1)
        pattern_left(step_2, step_3, n-1)
        pattern_up(step_3, step_4, n-1)
        pattern_left(step_4, step_5, n-1)
    else:
        segment(p_start, step_1)
        segment(step_1, step_2)
        segment(step_2, step_3)
        segment(step_3, step_4)
        segment(step_4, step_5)


if __name__ == '__main__': 
    setup_turtle()
    pointer.write(f"4 fractals forming a square, n = {n}", align='center', font=('Courier',18, 'bold'))
    
    pattern_left(Point(square_side_side,0) + origine, Point(0, 0) + origine, n)
    pattern_down(Point(square_side_side, square_side_side) + origine, Point(square_side_side, 0) + origine, n)
    pattern_right(Point(0, square_side_side) + origine, Point(square_side_side, square_side_side) + origine, n)
    pattern_up(Point(0, 0) + origine, Point(0, square_side_side) + origine, n)

    done()
     
