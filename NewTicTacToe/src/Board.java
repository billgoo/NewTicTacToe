
public class Board {
	/*
	 * ��Ա�����ĳ�ʼ���������޸ģ������ѡ���ʼ����ʽ
	 */
	protected char[][] cells;
	protected GameChessStrategy chessStrategy;
	protected GameWinStrategy_HVD winStrategy;
	protected GameChessStrategyFive chessStrategyFive;
	protected GameWinStrategy_HV winStrategy_hv;
	protected Player player = Player.X;
	protected int size;

	/*
	 * ���޸Ĺ��췽��������Ӻ��ʵĹ��췽��
	 */
	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}

		this.chessStrategy = chessStrategy;
		this.winStrategy = winStrategy;

		size = boardSize;
	}
	
	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HV winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		
		this.chessStrategy = chessStrategy;
		this.winStrategy_hv = winStrategy;

		size = boardSize;
	}

	public Board(int boardSize, GameChessStrategyFive chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}

		this.chessStrategyFive = chessStrategy;
		this.winStrategy = winStrategy;

		size = boardSize;
	}

	public Board(int boardSize, GameChessStrategyFive chessStrategy, GameWinStrategy_HV winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}

		this.chessStrategyFive = chessStrategy;
		this.winStrategy_hv = winStrategy;

		size = boardSize;
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
		System.out.print(" ");
		for (int i=0;i<size;i++){
			String s = "A"+i;
			System.out.print(s);
		}
		for(int i=0 ;i<size; i++){
			System.out.print(i+1);
			for(int j=0; j<size; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}
