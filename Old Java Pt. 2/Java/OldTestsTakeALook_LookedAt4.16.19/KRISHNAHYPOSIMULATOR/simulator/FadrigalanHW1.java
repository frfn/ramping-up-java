/*********************************************
 Program Developer: Flexer Fadrigalan
 CSCI 465 - Operating Systems Internal
 Homework 1 & 2
 300923576
 
 Product Description:
 An assignment that shows the building of an architecture which is to be called the HYPO Simulater –
 Also known as the hypothetical decimal machine. It is a machine that simulates by the use of functions
 or also known as methods to compute and to execute, it also a two address machine. In lieu to that, it is a program that essentially 
 simulates a computer. The machine demonstrates that all existing computing systems are binary. It has
 local variables that will represent the hardware and simulate the functions that the program will run.
 *********************************************/

package simulator;
import java.io.*;
import java.util.Scanner;
import java.util.*;
public class FadrigalanHW1 {
	
	/*****************************************************
	 Declaring Hardware Components as Global Variables
	 - Hypo Memory array of size 10,000 locations
	 - Hypo memory registers: MAR and MBR
	 - Clock
	 - CPU registers: an array of 8 general purpose registers (gpr)
	 - CPU registers (i) IR, (ii) psr, (iii) pc, (iv) sp
	 *****************************************************/
	
	/*******************
	 Global Variables as type "long"
	 *******************/
	
	private static long[] memory = new long[10000];	//array Memory with 10,000 locations
	private static long mar; //Memory Address Register
	private static long mbr; //Memory Buffer Register
	private static long clock; //clock
	private static long[] gpr = new long[8]; //General Purpose Registers
	private static long ir; //Instruction Register
	private static long psr; //Processor Status Register
	private static long pc; //Program Counter
	private static long sp; //stack Pointer – will be used on HW2
	
	public static void initializeSystem() {
		
		/**************************************
		 Initializing all Hypo Machine hardware components to zero
		 Memory, MAR, MBR, Clock, GPR, IR, PSR, PC
		 Since some are arrays, initialize them!
		 
		 Memory has 10000 memory, start with 9999
		 
		 GPR has 8 registers, start with 7
		 **************************************/
		
		memory = new long[0]; //10000
		mar = 0;
		mbr = 0;
		clock = 0;
		gpr = new long[0]; //8
		ir = 0;
		psr = 0;
		pc = 0;
		
		
		/************
		 Explicitly initializing the arrays, array memory and gpr
		 ************/
		
		for(int i = 0; i < 9999; i++) { 
			memory[i] = i;
		}
		
		
		for(int i = 0; i < 8; i++) { 
			gpr[i] = i;
		}
		
		
		
	}//end of InitializeSystem()
	public static int main() throws FileNotFoundException { //red because needs return value
		
		/*****************************
		 This method executes the program, reads the hypo machine language and dumps the information
		 being formatted into an output that is readable to the user. 
		 *****************************/
		final int ERRORVALUE = -1;
		
		Scanner scan = new Scanner(System.in);
		
		/******************
		 /Users/flexer/Library/Mobile Documents/com~apple~TextEdit/Documents/(NAME OF FILE).txt
		 ******************/
		
		System.out.print("Please enter filename path to be read: ");
		String readFile = scan.nextLine();
		
		long returnValue = absoluteLoader(readFile);
		
		if(returnValue == ERRORVALUE) {
			System.out.print("Return value is invalid...");
			return ERRORVALUE;
		}
		
		pc = returnValue;
		
		dumpMemory("After loading user program: ", 0, 99);
		
		long[] executionCompletionStatus = cpu();
		
		System.out.println();
		
		dumpMemory("After executing user program: ", 0, 99);
		
		return (int)executionCompletionStatus[0];
		
	}//end of main()
	public static int absoluteLoader(String fileName) throws FileNotFoundException { //red because needs return value

		/********************
		 This method loads the hypo memory language from the text file that is written
		 Reads the language and will load it respectively, with the fileName being the input parameter.
		 Task description of the method is that it will open the file containing Hypo machine user program
		 and loading it into the Hypo memory, once successful load, it will return the PC value. If failure,
		 it will display and error message
		 ********************/
		
		/**
		 Error codes below 
		 **/
		
		//ErrorFileOpen				Unable to open the file
		//ErrorInvalidAddress		Invalid address error
		//ErrorNoEndOfProgram		Missing end of program indicator
		//ErrorInvalidPCValue		invalid PC value
		//0 to Valid address range	Successful Load, valid PC value
		
		final int ERRORFILEOPEN = -1;
		final int ERRORINVALIDADDRESS = -1;
		final int ENDOFPROGRAM = -1;
		final int ERRORINVALIDPCVALUE = -1;
		final int ERRORINVALIDCONTENT = -1;
		final int INVALIDRANGE = -1;
		
		
		File readText = new File(fileName);			//reading the text file from computer		
		Scanner scanText;		//using a scanner to detect content from file
		
		try {
		scanText = new Scanner(readText);	//using scanner to read content
		}catch(FileNotFoundException e) {
			return ERRORFILEOPEN;
		}
		
		if(scanText == null) {
			System.out.print("Error reading file...");	//dead code but is needed to output print
			return ERRORFILEOPEN;
			
		}else {
		
		while(scanText.hasNextLine()) {
			String address = scanText.next(); //for every content in the line, as it scans, it reads content that is read and assign it to be address
			String content = scanText.next(); //same for content
				
			//will have to parse the content since string, will be type int
				int intAddress = Integer.parseInt(address);
				int intContent = Integer.parseInt(content);
			//content is now parsed as int and can be used as a numerical value
				
				if(intAddress == ENDOFPROGRAM) {			//if address is equals to -1, then stop program
					scanText.close();		//closing scanner
					if(intContent != ERRORINVALIDCONTENT) {		//if content is not equals to -1, then return content
						return intContent;
					}else {
						System.out.print("Error, invalid content...");
						return ERRORINVALIDCONTENT;
					}
				}else if(intAddress != INVALIDRANGE){ //if address is in range, then store to memory address
					memory[(int)intAddress] = intContent;
				}else {
					System.out.print("Error, invalid value...");
					scanText.close();
					return ERRORFILEOPEN;
				}
		}//end of "while"
		}//end of "else"
		scanText.close();
		return ERRORFILEOPEN;
	}//end of absoluteLoader
	
	public static long[] cpu() {
		
		/****************
		 This method simulates the the CPU of the program, wil have fetch cycles, decode cycles and
		 the execute cycle. Will serve to be one of the more important methods in the program.
		 ****************/
		
		/***
		 Initializing local variables for method CPU
		 ***/
		long stackLimit = 25;
		long opOneMode; //initialized two modes, Mode one and two
		long opTwoMode;
		long opOneGPR; //initialized two gprs, gpr one and two
		long opTwoGPR;
		
		long opOneAddress; //initialized two addresses, address one and address two
		long opTwoAddress;
		long opOneValue; //initialized two values, value one and two
		long opTwoValue;
		
		long result = 0; //value for result, will be used in the execute cycle
		
		long opCode; //initialized operand code and remainder at the next code
		long remainder;
		
		long status[] = null;
		
		boolean HALT = false; //initialized error codes
		boolean ERROR = false;
		final int ERRORVALUE = -1;
		final int ERRORFETCH = -1;
		final int HALTVALUE = -1;
		final int STACKOVERFLOW = -1;
		
		while(!(HALT && ERROR)) { //while it is not halt and there is no error
			
			/**********
			 Fetch cycle, reads the first word of the instruction pointed by the PC into MBR
			 The instructions will be needing more words, 2 word and 3 word instructions, they are fetched
			 WILL be based on instruction which is the opCode
			 when operand 1 and 2 values are fetched using modes
			 **********/
			
			if((0 < pc) && (pc < 2500)) { //2500 is the program area given in class
				
				mar = pc; //setting the memory address register to program counter
				pc++; //incrementing program counter by 1
				
				if(mar != ERRORVALUE) { //if no error is found then 
				mbr = memory[(int)mar]; //setting memory buffer register to hypo memory content pointed by mar
				}
				else {
					System.out.print("Error...");
					return new long[] {ERRORVALUE};
				}
				
			}//end for "if" (0 < pc) && (pc < 2500)
			
			ir = mbr;
			
			/************
			 Decode cycle, decodes the first word of the instruction into opCode
			 Operand 1 mode and Operand 1 GPR && Operand 2 mode and Operand 2 GPR
			 Uses integer division and modulo operators to obtain operand code
			 ************/
			
			/******
			 Operation below to obtain operand code
			 ******/
			
			opCode = ir / 10000;		//integer division – for OPCODE
			remainder = ir % 10000; 	//modulo gives remainder of integer division
			
			opOneMode = remainder / 1000;   //for OPONEMODE
			remainder = remainder  % 1000;
			
			opOneGPR = remainder / 100;	   //for OPONEGPR
			remainder = remainder % 100;
			
			opTwoMode = remainder / 10;		//for OPTWOMODE
			remainder = remainder % 10;
			
			opTwoGPR = remainder;			//for OPTWOGPR
			
			/**********
			 Validation to see if the operands are acceptable values, if not return error code
			 There are 6 modes 
			 There are 8 GPRs
			 **********/
			
			if(opOneMode < 0 && opOneMode > 6) { //opOneMode
				System.out.print("Invalid mode...");
				return new long[] {ERRORVALUE};
			}
			
			if(opTwoMode < 0 && opTwoMode > 6) { //opTwoMode
				System.out.print("Invalid mode...");
				return new long[] {ERRORVALUE};
			}
			
			if(opOneGPR < 0 && opOneGPR > 8) { //opOneGPR
				System.out.print("Invalid GPR...");
				return new long[] {ERRORVALUE};
			}
			
			if(opTwoGPR < 0 && opOneGPR > 8) { //opTwoGPR
				System.out.print("Invalid GPR...");
				return new long[] {ERRORVALUE};
			}
			
			/**************
			 Execute Cycle, fetches operand values based on opCode, since different opCode has
			 different number of operands, one opcode could just be by itself, one can have two
			 Example: 
			 Halt, Branch and System Call instruction have no operands
			 Push and Pop instructions have one operand
			 Conditional branch instructions have one operand
			 Add, subtract, multiply, divide and move have two operands
			 **************/
			
			switch((int)opCode) {
			
			case 0: //halt
				System.out.print("Halt instruction is encountered...\n");
				return new long[] {HALTVALUE};
				
			case 1: //add
				
				status = fetchOperand(opOneMode, opOneGPR); //first status, values for address one and gpr one
				
				if(status == null) {
					return new long[] {ERRORVALUE};	//if status1 is null, error
				}
				
				opOneAddress = status[0]; //fetchOperand returned an array, [0] is address
				opOneValue = status[1]; //								  [1] is value
				
				if(opOneAddress < ERRORFETCH) {
					System.out.print("Invalid address...");	//validation to see if value is -1, error
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORFETCH) {
					System.out.print("Invalid value...");	//validation like above
					return new long[] {ERRORVALUE};
				}
				
				status = fetchOperand(opTwoMode, opTwoGPR);	//second status, values for address two and gpr two
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opTwoAddress = status[0]; 
				opTwoValue = status[1];
				
				if(opTwoAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opTwoValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				result = opOneValue + opTwoValue; //result of the two values
				
				//Store the result into Op1 location
				if(opOneMode == 1) {
					gpr[(int)opOneGPR] = result;
					
				}else if(opOneMode == 6) {
					System.out.print("Destination operand cannot be immediate value...");
					return new long[] {ERRORVALUE};
					
				}else {
					//Store Result in hypo memory at location Op1Address;
					memory[(int)opOneAddress] = result;
				}
				clock+=3;
				break;
				
			case 2: //subtract
				
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0]; //fetchOperand returned an array, [0] is address
				opOneValue = status[1]; //								  [1] is value
				
				if(opOneAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				status = fetchOperand(opTwoMode, opTwoGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opTwoAddress = status[0]; 
				opTwoValue = status[1];
				
				if(opTwoAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opTwoValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				result = opOneValue - opTwoValue; //subtraction of the two values
				
				//Store the result into Op1 location
				if(opOneMode == 1) {
					gpr[(int)opOneGPR] = result;
					
				}else if(opOneMode == 6) {
					System.out.print("Destination operand cannot be immediate value...");
					return new long[] {ERRORVALUE};
					
				}else {
					//Store Result in hypo memory at location Op1Address;
					memory[(int)opOneAddress] = result;
				}
				clock+=3;
				break;
				
			case 3: //multiply
				
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0]; //fetchOperand returned an array, [0] is address
				opOneValue = status[1]; //								  [1] is value
				
				if(opOneAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				status = fetchOperand(opTwoMode, opTwoGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opTwoAddress = status[0]; 
				opTwoValue = status[1];
				
				if(opTwoAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opTwoValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				result = opOneValue * opTwoValue; //product of the two values
				
				//Store the result into Op1 location
				if(opOneMode == 1) {
					gpr[(int)opOneGPR] = result;
					
				}else if(opOneMode == 6) {
					System.out.print("Destination operand cannot be immediate value...");
					return new long[] {ERRORVALUE};
					
				}else {
					//Store Result in hypo memory at location Op1Address;
					memory[(int)opOneAddress] = result;
				}
				clock+=6;
				break;
				
			case 4:	//division
				
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0]; //fetchOperand returned an array, [0] is address
				opOneValue = status[1]; //								  [1] is value
				
				if(opOneAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				status = fetchOperand(opTwoMode, opTwoGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opTwoAddress = status[0]; 
				opTwoValue = status[1];
				
				if(opTwoAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opTwoValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				if(opTwoValue == 0) {
					System.out.print(opTwoValue + " is equals to 0, division by 0 is fatal. Error...");
					break;
				}else {
				
				result = opOneValue / opTwoValue; //quotient of the two values
				
				}
				
				//Store the result into Op1 location
				if(opOneMode == 1) {
					gpr[(int)opOneGPR] = result;
					
				}else if(opOneMode == 6) {
					System.out.print("Destination operand cannot be immediate value...");
					return new long[] {ERRORVALUE};
					
				}else {
					//Store Result in hypo memory at location Op1Address;
					memory[(int)opOneAddress] = result;
				}
				clock+=6;
				break;
				
			case 5:	//move
				
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0]; //fetchOperand returned an array, [0] is address
				opOneValue = status[1]; //								  [1] is value
				
				if(opOneAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				status = fetchOperand(opTwoMode, opTwoGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opTwoAddress = status[0]; 
				opTwoValue = status[1];
				
				if(opTwoAddress < ERRORFETCH) {
					System.out.print("Invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opTwoValue < ERRORFETCH) {
					System.out.print("Invalid value...");
					return new long[] {ERRORVALUE};
				}
				//////////////////////////////////////////////////////////////////
				//////////////////Fetched operand 1 and operand 2/////////////////
				//////////////////////////////////////////////////////////////////
				
				result = opOneValue + opTwoValue; //result of the two values
				
				//Store the result into Op1 location
				if(opOneMode == 1) {
					gpr[(int)opOneGPR] = result;
					
				}else if(opOneMode == 6) {
					System.out.print("Destination operand cannot be immediate value...");
					return new long[] {ERRORVALUE};
					
				}else {
					//Store Result in hypo memory at location Op1Address;
					memory[(int)opOneAddress] = result;
				}
				clock+=2;
				break;
				
			case 6: //branch or jump instruction
				
				if(pc != ERRORVALUE) {
					pc = memory[(int)pc];
				}else {
					System.out.print("Error...");
				return new long[] {ERRORVALUE};
				}
				
				clock+=2;
				break;
				
			case 7: //branch on minus
				
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0];
				opOneValue = status[1];
				
				if(opOneAddress < ERRORVALUE) {
					System.out.print("Error, invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORVALUE) {
					System.out.print("Error, invalid value...");
					return new long[] {ERRORVALUE};
				}
			
				if(opOneValue < 0) {
					if(pc != ERRORVALUE) {
						pc = memory[(int)pc];
					}else {
						System.out.print("Error...");
						return new long[] {ERRORVALUE};
					}
				}else {
					pc++;
				}
				clock+=4;
				break;
				
			case 8: //branch on plus
				
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0];
				opOneValue = status[1];
				
				if(opOneAddress < ERRORVALUE) {
					System.out.print("Error, invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORVALUE) {
					System.out.print("Error, invalid value...");
					return new long[] {ERRORVALUE};
				}
			
				if(opOneValue > 0) {
					if(pc != ERRORVALUE) {
						pc = memory[(int)pc];
					}else {
						System.out.print("Error...");
						return new long[] {ERRORVALUE};
					}
				}else {
					pc++;
				}
				clock+=4;
				break;
				
			case 9: //branch on zero
				
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0];
				opOneValue = status[1];
				
				if(opOneAddress < ERRORVALUE) {
					System.out.print("Error, invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORVALUE) {
					System.out.print("Error, invalid value...");
					return new long[] {ERRORVALUE};
				}
			
				if(opOneValue == 0) {
					if(pc != ERRORVALUE) {
						pc = memory[(int)pc];
					}else {
						System.out.print("Error...");
						return new long[] {ERRORVALUE};
					}
				}else {
					pc++;
				}
				clock+=4;
				break;
				
			case 10: //push
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0];
				opOneValue = status[1];
				
				if(opOneAddress < ERRORVALUE) {
					System.out.print("Error, invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORVALUE) {
					System.out.print("Error, invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				if(sp == stackLimit) {
					System.out.print("Stack overflow");
					return new long[] {STACKOVERFLOW};
				}
				
				sp += 1;
				
				memory[(int)sp] = opOneValue;
				break;
				
			case 11: //pop
				status = fetchOperand(opOneMode, opOneGPR);
				
				if(status == null) {
					return new long[] {ERRORVALUE};
				}
				
				opOneAddress = status[0];
				opOneValue = status[1];
				
				if(opOneAddress < ERRORVALUE) {
					System.out.print("Error, invalid address...");
					return new long[] {ERRORVALUE};
				}
				if(opOneValue < ERRORVALUE) {
					System.out.print("Error, invalid value...");
					return new long[] {ERRORVALUE};
				}
				
				if(sp < 0) {
					System.out.print("Stack underflow");
					return new long[] {STACKOVERFLOW};
				}
				
				memory[(int)sp] = opOneAddress;
				
				sp -= 1;
				break;
			/**	
			case 12: //system call
				if(pc < 0) {
					System.out.print("Error...");
					return new long[] {ERRORVALUE};
				}
				
				long systemCallID = memory[(int)pc++];
				status = systemCall(opOneValue);
				break;
			**/
			default: 
				
				System.out.print("Error, invalid operand code...");
				return new long[] {ERRORVALUE};
				
			}//end of switch statement
			
		}//end for while loop (!HALT && ERROR)
		
		return status;
		
	}//end of cpu method

	public static long[] fetchOperand(long opMode, long opReg) {
		
		/*******************
		 This method has input parameters, operand mode, and operand GPR value
		 
		 Since java cannot return two values, considering there two out parameters,
		 will think of a way to return two values.
		 
		 To fetch the operand for CPU usage, computes for CPU
		 *******************/
		
		/*********
		 opAddress and opValue are the two variables that will be returned!
		 *********/
		
		long opAddress;
		long opValue;
		
		final int INVALIDADDRESS = -1; //an error value
		final int INVALIDMODE = -1;
		final int INVALIDREGISTER = -1;
		final int INVALIDRANGE = -1;
		
		//validating if opMode is valid
		
		if(opMode < 0 && opMode > 8) {
			System.out.print("Mode is invalid...");
			return new long[] {INVALIDMODE};
		}//end of if statement
		
		//validating if opReg is valid
		
		if(opReg < 0 && opReg > 8) {
			System.out.print("Register is invalid...");
			return new long[] {INVALIDREGISTER};
		}
		
		switch((int)opMode) { //switch statement based by opCode
		
		case 1: //register mode
			opAddress = INVALIDADDRESS;
			opValue = gpr[(int)opReg];
			break;
		
		case 2: //register deferred mode – operand address in GPR and operand value in memory
			opAddress = gpr[(int)opReg];
			if(opAddress != INVALIDRANGE) {
				opValue = memory[(int)opAddress];
			}
			else {
				System.out.print("Invalid address...");
				return new long[] {INVALIDADDRESS};
			}
			break;
			
		case 3: //autoincrement mode – operand address in GPR and operand valye in memory
			opAddress = gpr[(int)opReg];
			if(opAddress != INVALIDRANGE) {
				opValue = memory[(int)opAddress];
			}else {
				System.out.print("Invalid address...");
				return new long[] {INVALIDADDRESS};
			}
			gpr[(int)opReg]++;
			break;
			
		case 4: //autodecrement mode 
			
			--gpr[(int)opReg];
			opAddress = gpr[(int)opReg];
			if(opAddress != INVALIDRANGE) {
				opValue = memory[(int)opAddress];
			}else {
				System.out.print("Invalid address...");
				return new long[] {INVALIDADDRESS};
			}
			break;
			
		case 5: //direct mode – operand address is in the instruction pointed by the program counter
					//check for valid address in program counter; if not return message and error
			opAddress = memory[(int)pc++];
			if(opAddress != INVALIDADDRESS) {
				opValue = memory[(int)opAddress];
			}
			else {
				System.out.print("Invalid address");
				return new long[] {INVALIDADDRESS};
			}
			break;
			
		case 6: //immediate mode
			opAddress = INVALIDADDRESS;
			opValue = memory[(int)pc++];
			break;
			
		default: //invalid mode
			System.out.print("Invalid mode...");
			return new long[] {INVALIDMODE};
		}//end of switch statement
		
		return new long[] {opAddress, opValue};
		//opAddress = 0
		//opValue = 1
		//when it comes to array index!
		
	}//end of fetchOperand method

	public static void dumpMemory(String parameter, int startAddress, int size) {
		
		/**********************
		 This method displays a string passed as one of the input parameters,
		 will also display content of GPRs, SP, PC, PSR, clock, and the contnet
		 of the specified memory locations in a specific format.
		 
		 It will have input parameters of string, long, and long.
		 First long, startAddress will be the start of the dress of memory location
		 second long, size will be the number of locations to dump
		 **********************/
	
			System.out.println(parameter);		//outputting the parameter
			
			/**************
			 Validation underneath
			 **************/
			
			if(startAddress < 0) {
				System.out.print("Error, start address is invalid...");
			}
			if(size < 0) {
				System.out.print("Error, size is invalid...");
			}
			
			/*************
			 Formatting the outout for dump memory
			 *************/
			
			System.out.println("GPRs:       \t G0\t G1\t G2\t G3\t G4\t G5\t G6\t G7\t SP\t PC");
			
			System.out.println("           \t " + gpr[0] + "\t " + gpr[1] + "\t " + gpr[2] + "\t " + gpr[3]
								+ "\t " + gpr[4] + "\t " + gpr[5] + "\t " + gpr [6] + "\t " + gpr[7] 
								+ "\t " + sp + "\t " + pc);
			
			System.out.println("Address:  \t " + "+0\t +1\t +2\t +3\t +4\t +5\t +6\t +7\t +8\t +9");
		
			int address = startAddress;		//initializing address to be startAddress
			int endAddress = startAddress + size;	//setting endAddress to startAddress plus size
			
			while(address < endAddress) {
				
				System.out.print("Value of address: "+ address + "  ");
				
				for(int i = 1; i < 10; i++) {
					if(address < endAddress) {
						System.out.print(" \t  " + memory[(int)address++]);
					}else {
						System.out.print("\nNo more value to print...");
						break;
					}
				}//end of "for" loop
				System.out.println();
			}//end of "while" loop
			System.out.print("End of line...\n");
			System.out.println("Clock value: " + clock);
			System.out.print("PSR value: " + psr + "\n");
	}//end of "dumpMemory"
	public static void main(String flex[]) {
		
		/*********************
		 This method had to be created in order for the program to be executed,
		 needed a different main to run program.
		 *********************/
		
		try {
			main();			//running the program
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}//end of HypoSimulator

