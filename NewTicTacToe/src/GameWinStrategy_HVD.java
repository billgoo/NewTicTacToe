/*
 * 请灵活修改或扩展本类
 */
public class GameWinStrategy_HVD {
	
	public Result check(char[][] cells)
	{
		Game game = new Game();
		char winChar = 0;
		for(int i=0; i<game.getSize; i++){
			for (int j=0;j<game.getSize;j++){
				if(cells[i][j] != '_' &&
						cells[i][j] == cells[i][j+1] && cells[i][j+1] == cells[i][j+2]){
					winChar = cells[i][j];
					break;
				}
			}

		}
		
		for(int j=0; winChar == 0 && j<game.getSize; j++){
			for (int i=0;i<game.getSize;i++){
				if(cells[i][j] != '_' &&
						cells[i][j] == cells[i+1][j] && cells[i+1][j] == cells[i+2][j]){
					winChar = cells[i][j];
					break;
				}
			}
		}

		for (int i=1;i<game.getSize;i++){
			if( winChar == 0 && cells[i][i] != '_' &&
					( (cells[i-1][i-1] == cells[i][i] && cells[i][i] == cells[i+1][i+1])
							|| (cells[i-1][i+1] == cells[i][i] && cells[i][i] == cells[i+1][i-1]) )){
				winChar = cells[i][i];
			}
		}

		
		switch(winChar){
			case 'X': return Result.X_WIN;
			case 'O': return Result.O_WIN;
			default: break;
		}
		
		for(int i = 0; i < game.getSize; ++i)
		{
			for(int j = 0; j < game.getSize; ++j)
			{
				if(cells[i][j] == '_')
					return Result.GAMING;
			}
		}
		
		return Result.DRAW;
	}
}
