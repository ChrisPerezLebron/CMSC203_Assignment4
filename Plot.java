public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth; 
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.depth = 1;
		this.width = 1;
	}
	
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.depth = p.depth;
		this.width = p.width;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	public boolean overlaps(Plot plot) {
		/* major lesson learned while writing this method: 
		 * 		it is better to check where two rectangles don't overlap rather than checking for every case in which they do overlap.
		 * 		
		 */
		
		boolean flag;
		
		//check if they're the same
		if ((this.x == plot.x && (this.x + this.width) == (plot.x + plot.width))
			&& (this.y == plot.y && (this.y + this.depth) == (plot.y + plot.depth))) {
			flag = true;
		}
		
		//FIRST BLOCK IS IF THIS OVERLAPS PLOT
		
		//else if top left corner (x,y) is inside this plot
		else if ((this.x > plot.x && this.x < (plot.x + plot.width)) 
			&& (this.y > plot.y && this.y < (plot.y + plot.depth))) {
			flag = true;
		}
		
		//else if top right corner (x + width, y) is inside this plot
		else if (((this.x + this.width) > plot.x && (this.x + this.width) < (plot.x + plot.width))		 
				 && (this.y > plot.y && this.y < (plot.y + plot.depth))) {
			flag = true;
		}
		
		//else if bottom left corner (x, y + depth) is inside this plot
		else if ((this.x > plot.x && this.x < (plot.x + plot.width)) 
				 && ((this.y + this.depth) > plot.y && (this.y + this.depth) < (plot.y + plot.depth))) {
			flag = true;
		}
		//else if bottom right corner (x + width, y + depth) is inside this plot
		else if (((this.x + this.width) > plot.x && (this.x + this.width) < (plot.x + plot.width))
				 && ((this.y + this.depth) > plot.y && (this.y + this.depth) < (plot.y + plot.depth))) {
			flag = true; 
		}
		
	
	
	
	
		
		
		
		//SECOND BLOCK IS IF PLOT OVERLAPS THIS
		//else if top left corner (x,y) is inside this plot
		else if ((plot.x > this.x && plot.x < (this.x + this.width)) 
			&& (plot.y > this.y && plot.y < (this.y + this.depth))) {
			flag = true;
		}
		
		//else if top right corner (x + width, y) is inside this plot
		else if (((plot.x + plot.width) > this.x && (plot.x + plot.width) < (this.x + this.width))		 
				 && (plot.y > this.y && plot.y < (this.y + this.depth))) {
			flag = true;
		}
		
		//else if bottom left corner (x, y + depth) is inside this plot
		else if ((plot.x > this.x && plot.x < (this.x + this.width)) 
				 && ((plot.y + plot.depth) > this.y && (plot.y + plot.depth) < (this.y + this.depth))) {
			flag = true;
		}
		//else if bottom right corner (x + width, y + depth) is inside this plot
		else if (((plot.x + plot.width) > this.x && (plot.x + plot.width) < (this.x + this.width))
				 && ((plot.y + plot.depth) > this.y && (plot.y + plot.depth) < (this.y + this.depth))) {
			flag = true; 
		}
		
	
		
		
		
		
		//if they overlap in a liner fashion. IE box1 has two corners in line with box2's horizontal and box2 has two corners in line with box1's horizontals 
		else if (this.x > plot.x && this.x < (plot.x + plot.width)
				 && (this.y == plot.y && (this.y + this.depth) == (plot.y + plot.depth))) {
			flag = true; 
		}		
		else if (this.x > plot.x && this.x < (plot.x + plot.width)
				 && (this.y == plot.y && (this.y + this.depth) == (plot.y + plot.depth))) {
			flag = true; 
		}
		else if (plot.x > this.x && plot.x < (this.x + this.width)
				 && (plot.y == this.y && (plot.y + plot.depth) == (this.y + this.depth))) {
			flag = true; 
		}	
		
		//overlap in a vertical linear fashion 
		else if (this.y > plot.y && this.y < (plot.y + plot.depth)
				 && (this.x == plot.x && (this.x + this.width) == (plot.x + plot.width))) {
			flag = true; 
		}		
		else if (plot.y > this.y && plot.y < (this.y + this.depth)
				 && (plot.x == this.x && (plot.x + plot.width) == (this.x + this.width))) {
			flag = true; 
		}	
		
		
		//otherwise if no corner is inside the plot
		else 
			flag = false;
		return flag;
		
	}
	
	
	public boolean encompasses(Plot plot) {
		boolean flag; 
		//if plot is inside this plot
		if ((plot.x >= this.x && (plot.x + plot.width) <= (this.x + this.width)) 
			 && (plot.y >= this.y && (plot.y + plot.depth) <= (this.y + this.depth))) {
			flag = true; 
		}
		else
			flag = false;
		return flag;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	public String toString() {
		return "Upper left: (" + this.x + "," + this.y + "); Width: " + this.width
				+ " Depth: " + this.depth;
	}
}