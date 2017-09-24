
public class GameWinStrategy_HV {
	public Result check(char[][] cells)
	{
		char winChar = 0;
		Game game = new Game();
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
