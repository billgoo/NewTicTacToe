/*
 * 请灵活修改或扩展本类
 */
public class GameChessStrategy {
	
	public void putChess(char[][] cells, Player currentPlayer, String chessPos)
	{
		int i = chessPos.charAt(1) - '1';
		int j = chessPos.charAt(0) - 'A';
		cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
	}
}
