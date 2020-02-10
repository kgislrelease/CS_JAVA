package com.program.main;

import java.util.Scanner;

import com.program.exception.CanvasDrawingException;

//main class receiving user command and execute
public class CanvasDrawing {

	CanvasUtil util;

	CanvasDrawing() {
		util = new CanvasUtil();
	}

	public static void main(String args[]) {
		try {
			CanvasDrawing obj = new CanvasDrawing();
			Scanner sn = new Scanner(System.in);
			String sCommand = new String();
			while (!sCommand.equals("Q")) {
				System.out.println("Enter Commands to Draw");
				sCommand = sn.nextLine();
				obj.executeCommands(sCommand);
			}
			System.out.println("Drawing Completed");
			sn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void executeCommands(String sCommand) throws Exception {
		try {
			char firstCharacter = sCommand.trim().charAt(0);
			String commandArray[];
			switch (firstCharacter) {
			case 'C':
				commandArray = sCommand.trim().split("\\s+");
				this.util = new CanvasUtil(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]));
				System.out.println(this.util.arrayToString());
				break;
			case 'L':
				commandArray = sCommand.trim().split("\\s+");
				this.util.putLine(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]),
						Integer.parseInt(commandArray[3]), Integer.parseInt(commandArray[4]), 'X');
				System.out.println(this.util.arrayToString());
				break;
			case 'R':
				commandArray = sCommand.trim().split("\\s+");
				this.util.putRectangle(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]),
						Integer.parseInt(commandArray[3]), Integer.parseInt(commandArray[4]), 'X');
				System.out.println(this.util.arrayToString());
				break;
			case 'B':
				commandArray = sCommand.trim().split("\\s+");
				this.util.fillTheSpace(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]),
						commandArray[3].charAt(0));
				System.out.println(this.util.arrayToString());
				break;
			 default:
				String s=Character.toString(firstCharacter);
				if(s != null && !(s.equals("Q"))) {
					System.out.println("Please Enter Valid Command!");
				}
				
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\nInvalid command. Try again!!\n");
		} 
		catch (CanvasDrawingException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println("\nError Occurred : " + e.getMessage() + "\nPlease try again");
		}
	}

}
