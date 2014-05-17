package com.aidancbrady.peerchess.piece;

import java.util.HashSet;
import java.util.Set;

import com.aidancbrady.peerchess.ChessMove;
import com.aidancbrady.peerchess.ChessPiece;
import com.aidancbrady.peerchess.ChessPos;
import com.aidancbrady.peerchess.ChessSquare;
import com.aidancbrady.peerchess.PeerUtils;

public class PieceBishop implements Piece
{
	@Override
	public boolean canMove(ChessSquare[][] grid, ChessMove move)
	{
		ChessPos pos = PeerUtils.findKing(move.getFromSquare(grid).housedPiece.side, grid);
		
		if(PeerUtils.isInCheck(move.getFromSquare(grid).housedPiece.side, pos, move.getFakeGrid(grid)))
		{
			return false;
		}
		
		return move.isValidDiagonal(grid);
	}
	
	@Override
	public Set<ChessPos> getCurrentPossibleMoves(ChessSquare[][] grid, ChessPos origPos)
	{
		Set<ChessPos> ret = new HashSet<ChessPos>();
		
		int x = origPos.xPos;
		int y = origPos.yPos;
		
		while(x < 7 && y > 0)
		{
			x++;
			y--;
			
			ChessPiece piece = grid[x][y].housedPiece;
			
			if(piece != null && piece.side == origPos.getSquare(grid).housedPiece.side)
			{
				break;
			}
			
			ret.add(new ChessPos(x, y));
			
			if(piece != null)
			{
				break;
			}
		}
		
		x = origPos.xPos;
		y = origPos.yPos;
		
		while(x > 0 && y < 7)
		{
			x--;
			y++;
			
			ChessPiece piece = grid[x][y].housedPiece;
			
			if(piece != null && piece.side == origPos.getSquare(grid).housedPiece.side)
			{
				break;
			}
			
			ret.add(new ChessPos(x, y));
			
			if(piece != null)
			{
				break;
			}
		}
		
		x = origPos.xPos;
		y = origPos.yPos;
		
		while(x < 7 && y < 7)
		{
			x++;
			y++;
			
			ChessPiece piece = grid[x][y].housedPiece;
			
			if(piece != null && piece.side == origPos.getSquare(grid).housedPiece.side)
			{
				break;
			}
			
			ret.add(new ChessPos(x, y));
			
			if(piece != null)
			{
				break;
			}
		}
		
		x = origPos.xPos;
		y = origPos.yPos;
		
		while(x > 0 && y > 0)
		{
			x--;
			y--;
			
			ChessPiece piece = grid[x][y].housedPiece;
			
			if(piece != null && piece.side == origPos.getSquare(grid).housedPiece.side)
			{
				break;
			}
			
			ret.add(new ChessPos(x, y));
			
			if(piece != null)
			{
				break;
			}
		}
		
		return ret;
	}
}
