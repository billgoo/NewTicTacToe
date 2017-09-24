
public class Board {
	/*
	 * ��Ա�����ĳ�ʼ���������޸ģ������ѡ���ʼ����ʽ
	 */
	protected char[][] cells;
	protected GameChessStrategy chessStrategy;
	protected GameWinStrategy_HVD winStrategy;
	protected Player player = Player.X;

	/*
	 * ���޸Ĺ��췽��������Ӻ��ʵĹ��췽��
	 */
	public Board(){
		cells = new char[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				cells[i][j] = '_';
			}
		}
		
		chessStrategy = new GameChessStrategy();
		winStrategy = new GameWinStrategy_HVD();
	}
	
	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		
		this.chessStrategy = chessStrategy;
		this.winStrategy = winStrategy;
	}

	
	public Result nextMove(String move) {
		chessStrategy.putChess(cells, nextPlay(), move);
		return winStrategy.check(cells);
	}
	
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}
	
	/*
	 * ����������޸�
	 */
	public void print(){
		System.out.println("  A B C");
		for(int i=0 ;i<3; i++){
			System.out.print(i+1);
			for(int j=0; j<3; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}
