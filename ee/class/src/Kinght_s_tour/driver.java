package Kinght_s_tour;

public class driver {
	static final int ROWS = 5;
	static final int COLUMNS = 5;
	static int[][] board = new int[ROWS][COLUMNS];
	
	static int [][] row_col_increment = new int[8][2];


	public static void main(String[] args) {
		row_col_increment[0][0] =  2;     
		row_col_increment[0][1] = -1;
		row_col_increment[1][0] =  1;     
		row_col_increment[1][1] = -2;
		row_col_increment[2][0] = -1;     
		row_col_increment[2][1] = -2;
		row_col_increment[3][0] = -2;     
		row_col_increment[3][1] = -1;
		row_col_increment[4][0] = -2;     
		row_col_increment[4][1] =  1;
		row_col_increment[5][0] = -1;     
		row_col_increment[5][1] =  2;
		row_col_increment[6][0] =  1;     
		row_col_increment[6][1] =  2;
		row_col_increment[7][0] =  2;     
		row_col_increment[7][1] =  1;

		// start game at lower corner of board
		int start_row = 4;
		int start_column = 0;
		board[start_row][start_column] = 1;
		
		record_this_decision_choice(start_row, start_column, 1);
		
		// make_next_decision(1, start_row, start_column)
		if (make_next_decision(1, start_row, start_column)) {
			System.out.println("We Did it!");
		}
		
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.print("\n");
			
		}
		// System.out.println("Done");

	}
	
	
	public static boolean make_next_decision(int last_move_number, int from_row, int from_col)
	{  
		// TO BE COMPLETE
	     return false; // at_goal;
	}
	
	
	public static boolean this_decision_choice_is_valid(int row, int column) {
		
		if (row >=0 && row < ROWS && column >=0 && column < COLUMNS && board[row][column] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static int next_choice_row(int choice_number, int from_row) {
		return (from_row + row_col_increment[choice_number][1]);
	}
	
	public static int next_choice_column(int choice_number, int from_column) {
		return (from_column + row_col_increment[choice_number][0]);
	}
	
	
	public static void record_this_decision_choice(int row, int column, 
													int this_move_number) {
		board[row][column] = this_move_number;
	}
	
	
	public static void unrecord_this_decision_choice(int row, int column) {
		board[row][column] = 0;
	}
	
	
	public static boolean goal_has_been_reached(int this_move_number) {
		if(this_move_number == ROWS * COLUMNS) {
			return true;
		} else {
			return false;
		}
	}
	

}
