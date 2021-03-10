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
public class FadrigalanHW2MTOPS {
	
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
	/*******
	MTOPS global variables – Homework Two
	*******/
	
	/***********
	 Part of initializePCB() – Homework 2
	 ***********/
	
	
	private static long endOfList = -1; //End of List
	private static long rq = endOfList; //Ready queue set to empty list
	private static long wq = endOfList; //Waiting queue is set to empty list
	private static long osFreeList = endOfList; 	//OS Free Memory list set to empty list
	private static long userFreeList = endOfList; //User free memory list is set to empty list
	private static long maxMemoryAddress = 10000;
	private static long stackLimit = 25;
	
	private static long userMode = 2;
	private static long osMode = 1;
	
	/*********
	 initializePCB global variables – Homework 2
	 *********/
	private static long processID = 1; //PID, process identifier
	private static long defaultPriority = 128; //Default priority
	private static long readyState = 1; //Ready state
	private static long waitingState = 3;
	
	private static long timeSlice = 200;
	
	/*****
	 Return values
	 *****/
	private static final int OK = 0;
	private static final int ERRORINVALIDMEMORYADDRESS = -1;
	private static final int ERRORNOFREEMEMORY = -1;
	private static final int ERRORINVALIDMEMORYSIZE = -1;
	private static final int ERRORINVALIDSIZEORMEMORY = -1;
	private static final int ERRORINVALIDFILE = -1;
	private static final int STACKOVERFLOW = -1;
	private static final int ERRORVALUE = -1;
	
	public static void initializeSystem() {
		
		/**************************************
		 Initializing all Hypo Machine hardware components to zero
		 Memory, MAR, MBR, Clock, GPR, IR, PSR, PC
		 Since some are arrays, initialize them!
		 
		 Memory has 10000 memory, start with 9999
		 
		 GPR has 8 registers, start with 7
		 **************************************/
		
		memory = new long[10000]; //10000
		mar = 0;
		mbr = 0;
		clock = 0;
		gpr = new long[8]; //8
		ir = 0;
		psr = 0;
		pc = 0;
		
		
		/************
		 Explicitly initializing the arrays, array memory and gpr
		 ************/
		
		for(int i = 0; i < memory.length; i++) { 
			memory[i] = 0;
		}
		
		
		for(int i = 0; i < gpr.length; i++) { 
			gpr[i] = 0;
		}
		// Create User free list using the free block address and size given in the class
		userFreeList = 2500;
		memory[2500] = endOfList;
		memory[2501] = 5000;
		// Create OS free list using the free block address and size given in the class
		osFreeList = 7500;
		memory[7500] = endOfList;
		memory[7501] = 5000;
		
	}//end of InitializeSystem()
	public static int main() throws IOException { //red because needs return value
		
		/*******
		 UPDATED MAIN: Homework Two!
		 New Main Function to accommodate MTOPS
		 *******/
		//run until shutdown
		
		initializeSystem(); //calling initializeSystem function
		
		long status = 0; //to use for while loop and the rest of the code
		
		while(status != 2) {	//2 is shutdown
			
			//check and process interrupt 
			
			status = checkAndProcessInterrupt();
			
			if(status == 2) {
				
				break; 		//exit out of loop because interrupt is 2, means shutdown
			}
			
			//dump RQ and WQ
			System.out.println("Printing out ready queue before CPU scheduling: ");
			printQueue(rq);
			System.out.println();
			
			System.out.println("Printing out waiting queue before CPU scheduling: ");
			printQueue(wq);
			System.out.println();
			
			//dump Memory
			dumpMemory("Dyanmic Memory Area before CPU scheduling: ", 0, 200);
			
			long runningPCBptr = selectProcessFromRQ(); //Select next process from RQ to give CPU
			
			dispatcher(runningPCBptr); //perform restore context using dispatcher
			System.out.println();
			
			System.out.println("After selecting process from ready queue: ");
			printQueue(rq);	//dumping ready queue after selecting process
			
			System.out.println();
			printPCB(runningPCBptr); //dumping PCB and CPU context
			
			//Execute instructions of the running process using the CPU
			long stat[] = cpu();
			if(stat[0] == timeSlice) { //if it reaches timeSlice, expired
				
				saveContext(runningPCBptr); //running process is losing CPU
				runningPCBptr = endOfList;				
				
			}else if(stat[0] < 0) { //run time error 
				
				terminateProcess(runningPCBptr);
				runningPCBptr = endOfList;
				
			}else if(stat[0] == ioGetcSystemCall()) { //io_getc
				
				memory[(int)runningPCBptr + 3] = OK;
				insertIntoWQ(runningPCBptr);
				runningPCBptr = endOfList;
				
			}else if(stat[0] == ioPutcSystemCall()) { //io_putc
				
				memory[(int)runningPCBptr + 3] = OK;
				insertIntoWQ(runningPCBptr);
				runningPCBptr = endOfList;
				
			}else { //unknown programming issue
				
				System.out.println("Unknown programming error message...");
				
			}
			
		}//end of while loop
		
		System.out.print("Operating System is shutting down...");
		
		return((int)status);
		
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
		
		/***
		 HOMEWORK TWO MTOPS VARIABLE DECLARATION
		 ***/
		long timeLeft = timeSlice;
		
		
		while(!(HALT && ERROR) && timeLeft > 0) { //while it is not halt and there is no error
			
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
				System.out.println("Halt instruction is encountered...\n");
				clock += 12;	//halt execution time
				timeLeft -= 12; //for illustration
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
				
			case 12: //system call
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
				
				status[0] = systemCall(opOneValue);
				
				clock += 12;
				timeLeft -= 11;
				break;
				
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
	public static void main(String flex[]) throws IOException {
		
		/*********************
		 This method had to be created in order for the program to be executed,
		 needed a different main to run program.
		 *********************/
			main();			//running the program
	}
	
	/******************
	MTOPS – Homework Two
	 * @throws FileNotFoundException 
	*******************/
	
	public static long createProcess(String filename, long priority) throws FileNotFoundException { 
		
		//allocate space for PCB
	
		long PCBptr = allocateOSMemory(21); //allocate space for Process Control Block
		
		if(PCBptr < 0) {
			System.out.print("There is no free space");	//validation
			return(ERRORNOFREEMEMORY);
		}
		
		//Initialize PCB: Set nextPCBlink to end of list, default priority, Ready state, and PID
		//Initialize PCB passing PCBptr as argument;

		initializePCB(PCBptr);	//initializing PCB pointer
		
		// Load the program
	    // Set value =load the program calling by Absolute Loader passing filename as argument;

		long value = absoluteLoader(filename);
		
		if(value < 0) {
			System.out.print(" Value is invalid...");
			return(ERRORINVALIDMEMORYADDRESS);
		}
		
		// store PC value in the PCB of the process
		memory[(int)PCBptr + 20] = value;
		
	    // Allocate stack space from user free list
		long ptr = allocateUserMemory(25); //stack size is 25, allocating user memory of size stack
		if(ptr < 0) {
			freeOSMemory(PCBptr, 25);
			return(ptr);
		}
		
		memory[(int)PCBptr + 19] = ptr + 25; //25 is stack size
		memory[(int)PCBptr + 5] = ptr; //stack start address
		memory[(int)PCBptr + 6] = 25; //stack size PCB index and stack size is 25
		memory[(int)PCBptr + 4] = priority; //priority PCB index and priority
		
		dumpMemory("Memory dump for create process: ", (int)value, 99);	//dumping program area
		
		printPCB(PCBptr);	//print PCB passing PCBptr
		
		insertIntoRQ(PCBptr);	//inserting PCV into ready queue
		
		return(OK);
		
	}
	
	public static void initializePCB(long PCBptr) {
		
		/***********
		 Initializing the PCB array area to 0
		 ***********/
		
		for(int i = 0; i < 21; i++) {
			memory[(int)PCBptr + i] = 0;					//Array initialization
		}
		
		memory[(int)PCBptr + 1] = processID++; //Setting PID field in the PCB to ProcessID ++ | ProcessID is global variable set to 1
		
		memory[(int)PCBptr + 4] = defaultPriority; //Setting priority field in the PCB to default priority, a global variable set to 128
		
		memory[(int)PCBptr + 2] = readyState;
		
		memory[(int)PCBptr + 0] = endOfList; //Setting "Next PCB Pointer" in the PCB to End of List, which is a global varialbe set to -1
		
		return;
	}// end of initalizePCB
	
	public static void printPCB(long PCBptr) {
		
		/*************
		 Printing the PCB values, will be formatted in a way that it will easy to be seen and read consistently
		 *************/
		System.out.println("--- PCB Information ---");
		System.out.println("PCB Address:    = " + memory[(int)PCBptr]); //outputting the PCB pointer address value 
		System.out.println("Next PCB Ptr:   = " + memory[(int)PCBptr + 0]); //outputting the "Next PCB Pointer" value
		System.out.println("PID:            = " + memory[(int)PCBptr + 1]); //outputting the PID value 
		System.out.println("State:          = " + memory[(int)PCBptr + 2]); //outputting the State value 
		System.out.println("PC:             = " + memory[(int)PCBptr + 20]); //outputting the PC value
		System.out.println("SP:             = " + memory[(int)PCBptr + 19]); //outputting the SP value
		System.out.println("Priority:       = " + memory[(int)PCBptr + 4]); //outputting the Priority value
		System.out.println("\n--- Stack Info ---");
		System.out.println("Start Address:  = " + memory[(int)PCBptr + 5]); //outputting the stack start address value
		System.out.println("Stack Size:     = " + memory[(int)PCBptr + 6]); //outputting the stack size value
		System.out.println("\n--- GPR Values ---");
		System.out.println("GPR 0:          = " + memory[(int)PCBptr + 11]);	//GPR 0
		System.out.println("GPR 1:          = " + memory[(int)PCBptr + 12]);	//GPR 1
		System.out.println("GPR 2:          = " + memory[(int)PCBptr + 13]);	//GPR 2
		System.out.println("GPR 3:          = " + memory[(int)PCBptr + 14]);	//GPR 3
		System.out.println("GPR 4:          = " + memory[(int)PCBptr + 15]);	//GPR 4
		System.out.println("GPR 5:          = " + memory[(int)PCBptr + 16]);	//GPR 5
		System.out.println("GPR 6:          = " + memory[(int)PCBptr + 17]);	//GPR 6
		System.out.println("GPR 7:          = " + memory[(int)PCBptr + 18]);	//GPR 7
	}// end of printPCB method
	
	public static long printQueue(long Qptr) {		
		
		/**********
		 Print Given Queue – Queue can be "Ready Queue" (rq) or "Waiting Queue" (wq)
		 Walk through the queue from the given pointer until end of list
		 Printing each PCB as you move from one PCB to the next
		 **********/
		
		/*****
		 Initializing the error codes if any
		 *****/
		
		long currentPCBptr = Qptr; //declaring the currentPCBptr to be equal for queue pointer
		
		if(currentPCBptr == endOfList) {
			System.out.println("List is empty...");		//validation if the PCBptr is equals to -1, output empty message
			return(OK);
		}//end of if block
		
		while(currentPCBptr != endOfList) {
			System.out.println(currentPCBptr);
			currentPCBptr = memory[(int)currentPCBptr]; //setting currentPCBptr equal to the next PCB pointer using currentPCBptr
		}//end of while block
		
		return(OK);		
	}//end of printQue method
	
	public static long insertIntoRQ(long PCBptr) {	
		
		/*****
		 Initializing the variables in the method if needed
		 *****/
		
		/*****
		 The ready queue is an ordered list. The first PCB in the queue is the highest priority, hence it will
		 get the CPU next when CPU scheduling (reallocation) is done. Keeping the RQ an ordered link list will
		 avoid searching the list for the highest priority process that should get the CPU. Therefore, by inserting
		 the given PCB according the CPU scheduling algorithm, which is the Priority Round Robin Algorithm. Scheduling
		 algorithm is implemented at the time of inserting the ready PCB in the Ready Queue.
		 *****/
		//inserting the PCB according to the Priority Round Robin algorithm
		//Using the priority in the PCB to find the correct place
		
		long previousPtr = endOfList;	//previous pointer = end of list
		long currentPtr = rq;			//current pointer = the ready queue
		
		if((PCBptr < 0)||(PCBptr > maxMemoryAddress)) {
			System.out.print("Invalid address error message...");
			return(ERRORINVALIDMEMORYADDRESS);
		}
		
		memory[(int)PCBptr + 2] = readyState;		//setting state to ready state
		
		memory[(int)PCBptr + 0] = endOfList;	//setting next pointer to end of list
		
		if(rq == endOfList) {		//if ready queue is empty, then ready queue is empty
			rq = PCBptr;
			return(OK);
		}
		
		/***
		 walking through the ready queue and finding the place to insert
		 PCB will be inserted at the end of its priority
		 ***/
		while(currentPtr != endOfList) {
			if(memory[(int)PCBptr + 4] > memory[(int)currentPtr + 4]) { //found the place to insert
				if(previousPtr == endOfList) {
					//enter PCB in the front of the list as first entry
					memory[(int)PCBptr + 0] = rq;
					rq = PCBptr;
					return(OK);
				}//end of second if block
				memory[(int)PCBptr + 0] = memory[(int)previousPtr + 0];
				memory[(int)previousPtr + 0] = PCBptr;
				return(OK);
			}//end of first if block
			else {
				previousPtr = currentPtr;
				currentPtr = memory[(int)currentPtr + 0];
			}//end of else block
		}//end of while
		
		memory[(int)previousPtr + 0] = PCBptr;
		return(OK);
	
	}//end of insertIntoRQ
	
	public static long insertIntoWQ(long PCBptr) {
		/*******
		 Variables to be declared if needed
		 *******/
	
		
		/*******
		 Insert the given PCB into the waiting queue at the front of the queue
		 *******/
		//inserting the given PCB at the front of the WQ 
		
		if((PCBptr < 0) || (PCBptr > maxMemoryAddress)) {
			System.out.print("Invalid PCB address...");		//validation if PCB pointer is valid
			return(ERRORINVALIDMEMORYADDRESS);
		}
		
		memory[(int)PCBptr + 2] = waitingState;		//setting to ready state --> setting it to wait
		memory[(int)PCBptr + 0] = wq;		//setting next pointer to end of list --> setting it to waiting queue
		
		wq = PCBptr;
		
		return(OK);
	
	}//end of insertIntoWQ method
	
	public static long selectProcessFromRQ() {
		/********
		 When the CPU has to be allocated to the next process in the ready queue, select the first process in the ready queue and return the
		 pointer to the PCB since processes in ready queue are already from highest to lowest priority
		 ********/
		long PCBptr = rq;		 //setting PCB pointer to ready queue
		
		if(rq != endOfList) {
			rq = memory[(int)rq];		    //removing first PCB from RQ;
		}
		
		memory[(int)PCBptr + 0] = endOfList; 		//setting point to end of list in the PCB
		
		
						
				 
		return(PCBptr);
								   
		
	}//end of selectProcessFromRQ
	
	public static void saveContext(long PCBptr) {
		/****
		 Running process is going to lose the CPU. Hence, its CPU context has to be saved in its PCB so that it can be restored when it gets the CPU at a later time.
		 CPU context consists of GPRs, SP, PC and PSR.
		 ****/
		//validation
		if((PCBptr < 0) || PCBptr > maxMemoryAddress) {
			System.out.print("Invalid PCB pointer...");
		}
		
		//copying all CPU GPRs into PCB using PCBptr without using loop
		memory[(int)PCBptr + 11] = gpr[0];
		memory[(int)PCBptr + 12] = gpr[1];
		memory[(int)PCBptr + 13] = gpr[2];
		memory[(int)PCBptr + 14] = gpr[3];
		memory[(int)PCBptr + 15] = gpr[4];
		memory[(int)PCBptr + 16] = gpr[5];
		memory[(int)PCBptr + 17] = gpr[6];
		memory[(int)PCBptr + 18] = gpr[7];
		
		//saving SP and PC field in the PCB
		memory[(int)PCBptr + 19] = sp;
		memory[(int)PCBptr + 20] = pc;
		
		return;
	}//end of saveContext
	
	public static void dispatcher(long PCBptr) {
		
	/****
	 Restore CPU Context from the given PCB
	 The selected process has been given the CPU to run.  Hence, restore its CPU context from the PCB into the CPU registers.  
	 The operating system code that performs the restore context is called Dispatcher.  Hence, the function is named as Dispatcher instead of restore context.
	 ****/
	//validation
			if((PCBptr < 0) || PCBptr > maxMemoryAddress) {
				System.out.print("Invalid PCB pointer...");
			}
			
			//copying CPU GPR register values from given PCB into the CPU registers
			gpr[0] = memory[(int)PCBptr + 11];
			gpr[1] = memory[(int)PCBptr + 12];
			gpr[2] = memory[(int)PCBptr + 13];
			gpr[3] = memory[(int)PCBptr + 14];
			gpr[4] = memory[(int)PCBptr + 15];
			gpr[5] = memory[(int)PCBptr + 16];
			gpr[6] = memory[(int)PCBptr + 17];
			gpr[7] = memory[(int)PCBptr + 18];
			
			//restore SP and PC from given PCB
			sp = memory[(int)PCBptr + 19];
			pc = memory[(int)PCBptr + 20];
			
			//setting system mode to user mode
			psr = userMode; //usermode is 2
		return;
	}//end of dispatcher
	
	public static void terminateProcess(long PCBptr) { 
		
		freeUserMemory(memory[(int)PCBptr + 5], memory[(int)PCBptr + 6]);
		//return stack memory using stack start address and stack size in the given PCB
		
		freeUserMemory(PCBptr, 21);
		//Return PCB memory using the PCBptr
		
	}//end of termianteProcess
	
	public static long allocateOSMemory(long requestedSize) {
		
		if(osFreeList == endOfList) {
			System.out.print("No free OS memory...");			//validation 
			return(ERRORNOFREEMEMORY);
		}
		if(requestedSize < 0) {
			System.out.print("Invalid size error... ");		//validation
			return(ERRORINVALIDMEMORYSIZE);
		}
		if(requestedSize == 1) {
			requestedSize = 2;	//minimum allocated memory is 2 locations
		}
		
		long currentPtr = osFreeList;
		long previousPtr = endOfList;
		
		while(currentPtr != endOfList) {
			if(memory[(int)currentPtr + 1] == requestedSize) {	//checking each block in the link list until lock with requested memory is found
				if(currentPtr == osFreeList) {					//block is found with requested size, adjusting pointers inside if found
					osFreeList = memory[(int)currentPtr];		//first entry is pointer to next block
					memory[(int)currentPtr] = endOfList;			//reset next pointer in the allocated block
					return(currentPtr);							//return memory address
				}//end of if
				else {											//else not in first block
					memory[(int)previousPtr] = memory[(int)currentPtr];	//point to next block
					memory[(int)currentPtr] = endOfList; //reset next pointer in the block
					return(currentPtr); //return memory address
				}//end of else
			}//end of if BLOCK
			else if(memory[(int)currentPtr + 1] > requestedSize){		//found block with size greater than requested size
				if(currentPtr == osFreeList) {	//first block
					memory[(int)currentPtr + (int)requestedSize] = memory[(int)currentPtr]; //move next block pointer
					memory[(int)currentPtr + (int)requestedSize + 1] = memory[(int)currentPtr + 1] - requestedSize;
					osFreeList = currentPtr + requestedSize; //address of reduced block
					memory[(int)currentPtr] = endOfList;	//reset next pointer in the allocated block
					return(currentPtr);
				}//end of if
				else {
					memory[(int)currentPtr + (int)requestedSize] = memory[(int)currentPtr];  // move next block ptr
					memory[(int)currentPtr + (int)requestedSize + 1] = memory[(int)currentPtr +1] - requestedSize;
					memory[(int)previousPtr] = currentPtr + requestedSize;  // address of reduced block
					memory[(int)currentPtr] = endOfList;  // reset next pointer in the allocated block
					return(currentPtr);	// return memory address
				}//end of else
			}//end of else if
			else {	//look at next block
				previousPtr = currentPtr;
				currentPtr = memory[(int)currentPtr];
			}//end of else
		}//end of while loop
		
		System.out.print("No free OS memory error");
		return(ERRORNOFREEMEMORY);
	}//end of allocateOSMemory
	
	public static long freeOSMemory(long ptr, long size) {
		
		if(ptr < 0 || ptr > osFreeList) {		//if address is not valid then error
			System.out.print("Invalid address...");
			return(ERRORINVALIDMEMORYADDRESS);
		}
		if(size == 1) {		//checking for minimum allocated siE, which is 2 even if user asks for 1 location
			size = 2;
		}
		else if(size < 1 || (ptr + size) >= maxMemoryAddress) {	//invalid size 
			System.out.print("Invalid size or address...");
			return(ERRORINVALIDSIZEORMEMORY);
		}
		
		// Return memory to OS free space.  Insert at the beginning of the link list
		// Insert the given free block at the beginning of the OS free list;

		memory[(int)ptr + 0] = osFreeList;
		memory[(int)ptr + 1] = size;
		osFreeList = memory[(int)ptr]; //or just ptr DONT KNOW YET.
		
		return(OK);
	}//end of freeOSMemory
	
	public static long allocateUserMemory(long requestedSize) {
		
		if(userFreeList == endOfList) {
			System.out.print("No free OS memory...");			//validation 
			return(ERRORNOFREEMEMORY);
		}
		if(requestedSize < 0) {
			System.out.print("Invalid size error... ");		//validation
			return(ERRORINVALIDMEMORYSIZE);
		}
		if(requestedSize == 1) {
			requestedSize = 2;	//minimum allocated memory is 2 locations
		}
		
		long currentPtr = userFreeList;
		long previousPtr = endOfList;
		
		while(currentPtr != endOfList) {
			if(memory[(int)currentPtr + 1] == requestedSize) {	//checking each block in the link list until lock with requested memory is found
				if(currentPtr == userFreeList) {					//block is found with requested size, adjusting pointers inside if found
					userFreeList = memory[(int)currentPtr];		//first entry is pointer to next block
					memory[(int)currentPtr] = endOfList;			//reset next pointer in the allocated block
					return(currentPtr);							//return memory address
				}//end of if
				else {											//else not in first block
					memory[(int)previousPtr] = memory[(int)currentPtr];	//point to next block
					memory[(int)currentPtr] = endOfList; //reset next pointer in the block
					return(currentPtr); //return memory address
				}//end of else
			}//end of if BLOCK
			else if(memory[(int)currentPtr + 1] > requestedSize){		//found block with size greater than requested size
				if(currentPtr == userFreeList) {	//first block
					memory[(int)currentPtr + (int)requestedSize] = memory[(int)currentPtr]; //move next block pointer
					memory[(int)currentPtr + (int)requestedSize + 1] = memory[(int)currentPtr + 1] - requestedSize;
					userFreeList = currentPtr + requestedSize; //address of reduced block
					memory[(int)currentPtr] = endOfList;	//reset next pointer in the allocated block
					return(currentPtr);
				}//end of if
				else {
					memory[(int)currentPtr + (int)requestedSize] = memory[(int)currentPtr];  // move next block ptr
					memory[(int)currentPtr + (int)requestedSize + 1] = memory[(int)currentPtr +1] - requestedSize;
					memory[(int)previousPtr] = currentPtr + requestedSize;  // address of reduced block
					memory[(int)currentPtr] = endOfList;  // reset next pointer in the allocated block
					return(currentPtr);	// return memory address
				}//end of else
			}//end of else if
			else {	//look at next block
				previousPtr = currentPtr;
				currentPtr = memory[(int)currentPtr];
			}//end of else
		}//end of while loop
		
		System.out.print("No free user memory error");
		return(ERRORNOFREEMEMORY);
		
	}//end of allocateUserMemory
	
	public static long freeUserMemory(long ptr, long size) {
		
		if(ptr < 0 || ptr > maxMemoryAddress) {		//if address is not valid then error
			System.out.print("Invalid address...");
			return(ERRORINVALIDMEMORYADDRESS);
		}
		if(size == 1) {		//checking for minimum allocated siE, which is 2 even if user asks for 1 location
			size = 2;
		}
		else if(size < 1 || (ptr + size) >= maxMemoryAddress) {	//invalid size 
			System.out.print("Invalid size or address...");
			return(ERRORINVALIDSIZEORMEMORY);
		}
		
		// Return memory to OS free space.  Insert at the beginning of the link list
		// Insert the given free block at the beginning of the OS free list;

		memory[(int)ptr + 0] = userFreeList;
		memory[(int)ptr + 1] = size;
		userFreeList = memory[(int)ptr]; //or just ptr DONT KNOW YET.
		
		return(OK);
		
	}//end of freeUserMemory
	
	public static long checkAndProcessInterrupt() throws IOException {
		
		//prompting and reading the interrupt ID
		/**********
		// 0 – no interrupt
		// 1 – run program
		// 2 – shutdown system
		// 3 – Input operation completion (io_getc)
		// 4 – Output operation completion (io_putc)
		 **********/
		
		Scanner scan = new Scanner(System.in);
		int interruptID;
		
		System.out.println("Possible interrupts:");
		System.out.println("0 – No Interrupt");
		System.out.println("1 – Run Program");
		System.out.println("2 – Shutdown System");
		System.out.println("3 – Input Operation Completion (io_getc)");
		System.out.println("4 – Output Operation Completion (io_putc)");
		
		System.out.print("Please input an interrupt ID: ");
	
		
		interruptID = scan.nextInt();	//reading the interrupt ID from user
		
		System.out.println("Interrupt ID that was chosen: " + interruptID);
		
		
		
		switch(interruptID) {
		
		case 0: //no interrupt
			break;
		case 1: //run program
			isrRunProgramInterrupt();
			break;
		case 2: //shutdown system
			isrShutdownSystem();
			break;
		case 3: //input operation completion – io_getc
			isrInputCompletionInterrupt();
			break;
		case 4: //output operation completion – io_putc
			isrOutputCompletionInterrupt();
		default: //invalid interrupt ID
			System.out.println("User have chosen invalid interrupt ID...");
			break;
		}//end of switch
		
		
		
	
		return interruptID;
	}//end of checkAndProcessInterrupt
	
	public static void isrRunProgramInterrupt() throws FileNotFoundException {
		
		/*****
		 Prompt and read filename;
		 Call Create Process passing filename and Default Priority as arguments
		 return
		 *****/
				
		Scanner scan = new Scanner(System.in);		//using a scanner to detect content from file
		System.out.print("Please enter filename: ");
		String file = scan.nextLine();
		File readFile = new File(file);
		
		try {
			scan = new Scanner(readFile);	//using scanner to read content
			}catch(FileNotFoundException e) {
				System.out.print("File not found...");
			
			}
	
		createProcess(file, 128);	//File name into create process as well as default priority being 128
		
		
		
		
	}//end of isrRunProgramInterrupt
	
	public static void isrInputCompletionInterrupt() {
		
		/******
		 Read PID of the process completing the io_getc operation and read one 
		 character from the keyboard (input device).  Store the 
		 character in the GPR in the PCB of the process.
		 *****/
		
		searchAndRemovePCBfromWQ(ioGetcSystemCall());
		
		selectProcessFromRQ();
		
		return;
		
		
	}//end of isrInputCompletionInterrupt
	
	public static void isrOutputCompletionInterrupt() {				
		
		/****
		 Output Completion Interrupt
		 Read PID of the process completing the io_putc operation 
		 and display one character on the monitor (output device) from 
		 the the GPR in the PCB of the process.
		 ****/
		
		searchAndRemovePCBfromWQ(ioPutcSystemCall());
		
		selectProcessFromRQ();
		
		return;
		
		
		
	}//end of  end of isrOutputCompletionInterrupt
	
	public static void isrShutdownSystem() {
		
		/****
		 Shutdown System Interrupt
	  	 Terminate all processes in RQ and WQ and exit from the program.
		 This is the only place that the operating system program should exit
		 ****/
		
		//terminate all processes in Ready Queue one by one
		long ptr = rq;
		
		while(ptr != endOfList) {
			rq = memory[(int)ptr];
			terminateProcess(ptr);
			ptr = rq;
		}
		
		//terminate all processes in Waiting queue one by one
		ptr = wq;
		
		while(ptr != endOfList) {
			wq = memory[(int)ptr];
			terminateProcess(ptr);
			ptr = wq;
		}
		
		
	}//end of isrShutdownSystem
	
	public static long searchAndRemovePCBfromWQ(long pid) {
		
		/****
		 Search the WQ for the matching pid.
		 When a match is found remove it from WQ and return PCB pointer.
		 If no match is found, return invalid pid error code
		 ***/
		
		long currentPCBptr = wq;
		long previousPCBptr = endOfList;
		
		// Search WQ for a PCB that has the given pid
		// If a match is found, remove it from WQ and return the PCB pointer
		while(currentPCBptr != endOfList) {
			if(memory[(int)currentPCBptr + 1] == pid) {	//match found, remove from WQ
				if(previousPCBptr == endOfList) { //first PCB
					wq = memory[(int)currentPCBptr + 0];
				}
				else {	//not first PCB
					memory[(int)previousPCBptr + 0] = memory[(int)currentPCBptr + 0];
				}
				memory[(int)currentPCBptr + 0] = endOfList;
				return(currentPCBptr);
			}
			previousPCBptr = currentPCBptr;
			currentPCBptr = memory[(int)currentPCBptr + 0];
		}
		//No matching PCB is found, display pid message and return End of List code
		//Display pid not found message;
		System.out.print("No matching PCB is found...");
		return endOfList;
	}//end of searchAndRemovePCBfromWQ
	
	public static long systemCall(long systemCallID) {
		
		psr = osMode;
		
		long status = OK;
		
		switch((int)systemCallID) {
			case 1: // Create process – user process is creating a child process. 
				System.out.print("Create process system call not implemented...");
				break;
			case 2: // Delete process
				System.out.print("Delete process system call not implemented...");
				break;
			case 3: // process inquiry
				System.out.print("Process inquiry system call not implemented...");
				break;
			case 4: // Dynamic memory allocation: Allocate user free memory system call
				status = memAllocSystemCall();
				break;
			case 5: // Free dynamically allocated user memory system call
				status = memFreeSystemCall();
				break;
			case 6: // message send
				System.out.print("Message send process system call not implemented...");
				break;
			case 7: // message received
				System.out.print("Message received process system call not implemented...");
				break;
			case 8: // io_getc  system call
				status = ioGetcSystemCall();
				break;
			case 9: // io_putc system call
				status = ioPutcSystemCall();
				break;
			case 10: // get time process
				System.out.print("Get time process system call not implemented...");
				break;
			case 11: // set time process
				System.out.print("Set time process system call not implemented...");
				break;
			default:			//invalid system call ID
				System.out.print("Invalid system call ID...");
				break;
		}//end of switch block
		
		psr = userMode;
		
		return(status);
		
	}//end of systemCall
	
	public static long memAllocSystemCall() {
		
		//Allocate memory from user free list
		//Return status from the function is either the 
		//address of allocated memory or an error code
		
		long size = gpr[2];
		
		if(gpr[2] == ERRORVALUE) {
			System.out.print("General purpose register 2 is invalid and out of range...");
			return ERRORVALUE;
		}
		
		if(size == 1) {	//checking size of 1 and changing it to 2
			size = 2;
		}
		
		gpr[1] = allocateUserMemory(size);
		
		if(gpr[1] < 0) {
			gpr[0] = gpr[1];
		}else {
			gpr[0] = OK;
		}
		
		System.out.println("Memory allocation system call: ");
		System.out.println("GPR 0:" + gpr[0]);
		System.out.println("GPR 1:" + gpr[1]);
		System.out.println("GPR 2:" + gpr[2]);

		return gpr[0];
		
	}//end of memAllocSystemCall
	
	public static long memFreeSystemCall() {
		
		// Return dynamically allocated memory to the user free list
		// GPR1 has memory address and GPR2 has memory size to be released
		// Return status in GPR0
		
		long size = gpr[2];
		
		if(gpr[2] == ERRORVALUE) {
			System.out.print("General purpose register 2 is invalid and out of range...");
			return ERRORVALUE;
		}
		
		if(size == 1) {
			size = 2;
		}
		
		gpr[0] = freeUserMemory(gpr[1], size);
		
		System.out.println("Memory free system call: ");
		System.out.println("GPR 0:" + gpr[0]);
		System.out.println("GPR 1:" + gpr[1]);
		System.out.println("GPR 2:" + gpr[2]);

		return gpr[0];
		
		
	}//end of memFreeSystemCall
	
	public static long ioGetcSystemCall() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Input operation event code: ");
		long operationEventCode = scan.nextInt();
		
		
		return operationEventCode;
		
	}//end of ioGetSystemCall
	
	public static long ioPutcSystemCall() {
		
		return ioGetcSystemCall();
		
		
	}//end of ioPutcSystemCall
	
}//end of HypoSimulator

