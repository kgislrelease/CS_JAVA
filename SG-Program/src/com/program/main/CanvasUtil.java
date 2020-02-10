package com.program.main;

import com.program.exception.CanvasDrawingException;


//Utility Class for drawing
public class CanvasUtil {

	char[][] drawArray;
	int w, h;

	public CanvasUtil() {

	}

	public CanvasUtil(int w, int h) throws Exception {
		try {
			if (w < 1 || h < 1) {
				throw new CanvasDrawingException("Canvas width and height can't be 0 or less than 0");
			}
			w += 2;
			h += 2;
			this.w = w;
			this.h = h;
			this.drawArray = new char[h][w];
			putLine(0, 0, this.w - 1, 0, '-');
			putLine(0, this.h - 1, this.w - 1, this.h - 1, '-');
			putLine(0, 1, 0, this.h - 2, '|');
			putLine(this.w - 1, 1, this.w - 1, this.h - 2, '|');
		} catch (Exception e) {
			throw e;
		}
	}

	public void putLine(int x1, int y1, int x2, int y2, char sChar) throws CanvasDrawingException  {
		canvasAvailable();
		for (int i = y1; i <= y2; i++) {
			for (int j = x1; j <= x2; j++) {
				this.drawArray[i][j] = sChar;
			}
		}
	}

	public void putRectangle(int x1, int y1, int x2, int y2, char sChar) throws CanvasDrawingException  {
		canvasAvailable();
		// xaxis line
		putLine(x1, y1, x1, y2, sChar);
		putLine(x2, y1, x2, y2, sChar);
		// yaxis Line
		putLine(x1, y1, x2, y1, sChar);
		putLine(x1, y2, x2, y2, sChar);
	}

	public String arrayToString() throws CanvasDrawingException  {
		canvasAvailable();
		StringBuilder sb = new StringBuilder();
		String sArrayString = null;

		for (int i = 0; i < this.h; i++) {
			for (int j = 0; j < this.w; j++) {
				sb.append(this.drawArray[i][j]);
			}
			sb.append("\n");
		}
		sArrayString = sb.toString().trim();
		return sArrayString;
	}

	public void fillTheSpace(int x, int y, char sChar) throws CanvasDrawingException  {
		canvasAvailable();

		if ((int) this.drawArray[y][x] != 0) {
			return;
		}

		if (x > 0 || x < this.h || y > 0 || y < this.w) {

			if ((int) this.drawArray[y][x] == 0) {
				this.drawArray[y][x] = sChar;
			}

			fillTheSpace(x + 1, y, sChar);
			fillTheSpace(x - 1, y, sChar);
			fillTheSpace(x, y - 1, sChar);
			fillTheSpace(x, y + 1, sChar);
		}

	}

	private void canvasAvailable() throws CanvasDrawingException  {
		if (this.drawArray == null)
			throw new CanvasDrawingException("first Draw a canvas");
	}

}
