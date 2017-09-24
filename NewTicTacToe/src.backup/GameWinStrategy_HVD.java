/*
 * 请灵活修改或扩展本类
 */
public class GameWinStrategy_HVD {
	
	public Result check(char[][] cells)
	{
		char winChar = 0;
		for(int i=0; i<3; i++){
			if(cells[i][0] != '_' && 
					cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]){
				winChar = cells[i][0];
				break;
			}
		}
		
		for(int j=0; winChar == 0 && j<3; j++){
			if(cells[0][j] != '_' &&
					cells[0][j] == cells[1][j] && cells[1][j] == cells[2][j]){
				winChar = cells[0][j];
				break;
			}
		}
		
		if( winChar == 0 && cells[1][1] != '_' &&
				( (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2])
				|| (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) )){
			winChar = cells[1][1];
		}
		
		switch(winChar){
			case 'X': return Result.X_WIN;
			case 'O': return Result.O_WIN;
			default: break;
		}
		
		for(int i = 0; i < 3; ++i)
		{
			for(int j = 0; j < 3; ++j)
			{
				if(cells[i][j] == '_')
					return Result.GAMING;
			}
		}
		
		return Result.DRAW;
	}
}
