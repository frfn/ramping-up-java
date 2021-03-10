package hypoSimulator;
import java.io.*;
import java.util.Scanner;
public class Simulator {
	
	/*
	 * Declare Hardware Components as Global Variables
// Declare the following Hypo Machine hardware components
// as global variables of type "long"

(1)	Hypo memory array of size 10,000 locations (words)
(2)	Hypo memory registers: (i) mar, (ii) mbr
(3)	clock
(4)	CPU registers: an array of 8 general purpose registers (gpr)
(5)	CPU registers (i) IR, (ii) psr, (iii) pc, (iv) sp

	 */
	
	//CLASS VARIABLES
	
	private static long[] Memory = new long[10000]; //memory array of size 10,000 words
	private static long MAR; //memory address registers
	private static long MBR; //memory buffer register
	private static long clock; //clock
	private static long[] GPR = new long[8]; //the General Purpose Registers (CPU registers)
	private static long[] IR = new long[3]; //the instruction register, has 1-3 words 
	private static long PSR, PC, SP; //CPU registers
	
	
	/*
// ************************************************************
// Function: InitializeSystem
//
// Task Description:
// 	Set all global system hardware components to 0 
//
// Input Parameters
//	None
//
// Output Parameters
//	None
//
// Function Return Value
//	None
// ************************************************************

void InitializeSystem()
{
	// Initialize all Hypo Machine hardware components to zero

(1)	Hypo memory array of size 10,000 locations (words)
(2)	Hypo memory registers: (i) mar, (ii) mbr
(3)	clock
(4)	CPU registers: an array of 8 general purpose registers (gpr)
(5)	CPU registers (i) IR, (ii) psr, (iii) pc, (iv) sp

}  // end InitializeSystem() function

	 */
	
	public static void InitializeSystem() {
		
		//All hardware components are initialized to zero
		
		/*
		 * I kept the array size the same assuming they will be used up and limited
		 */
		
		Memory = new long[10000];
		
		MAR = 0;
		
		MBR = 0;
		
		clock = 0;
		
		GPR = new long[8];
		
		IR = new long[3];
		
		PSR = 0;
		
		PC = 0;
		
		SP = 0;
		
	}//end of InitializeSystem
	
	public static long[] programMain() throws IOException {
		
		final long[] errorCode = new long[1];
		errorCode[0] = -1;
		
		long[] ExecutionCompletionStatus = new long[4];
		
		
		long[] returnValue = new long[4];
		
		AbsoluteLoader("/Users/flexer/Library/Mobile Documents/com~apple~TextEdit/Documents/fadrigalanHWsimulator.txt");
		
		returnValue[0] = AbsoluteLoader("/Users/flexer/Library/Mobile Documents/com~apple~TextEdit/Documents/fadrigalanHWsimulator.txt");
		
		if(returnValue[0] < errorCode[0]) {
			System.out.println("The value returned is invalid...");
			return errorCode;
		}
		
		PC = returnValue[0];
		
		DumpMemory("After loading user program: ", 0, 99);
		
		ExecutionCompletionStatus = CPU(); //which element should this ne since CPU IS A LONG
		
		DumpMemory("After executing user program: ", 0, 99);
		
		return(ExecutionCompletionStatus);
		
		
		
	}//end of main
	
	public static int AbsoluteLoader(String fileName) throws IOException {
		
		//each error are associated with a negative number, notifying what has happened if there was an error
		
		final int ErrorFileOpen = -1;	
		final int ErrorInvalidAddress = -2;
		final int ErrorNoEndOfProgram = -3;
		final int ErrorInvalidPCValue = -4;
		//0 - 5999 is the valid address range
		
		
			File text = new File(fileName); //creating File 
			Scanner scanText = null;
			try {
			scanText = new Scanner(text); //scanning the file
			}catch(FileNotFoundException e) {
				
			}
			
			if(scanText == null) 
				
				System.out.println("Error reading file...");
			
			else 
				
				while(scanText.hasNextLine()) {	
					
					
					
					
					String Address = scanText.next();
					
					String Content = scanText.next();
					

					long longAddress = Long.parseLong(Address);
				
					long longContent = Long.parseLong(Content);
				
					
					
						if(longAddress == -1) {
							
							scanText.close();
							
							return ErrorFileOpen;
							
						}
						else if(!scanText.equals("-1")) {
							
							Memory[(int)longAddress] = longContent;
							
						}
						else {
							
							System.out.println("Error, cannot retrieve file");
							return ErrorFileOpen;
							
						}
						
						
			}//end of while loop
			
			
			
			//return PC in main
			
			scanText.close();
			
			return ErrorFileOpen;	
			
		
	}//end of AbsoluteLoader

	public static long[] CPU() {
		
		//declare local variables here
		
		long operandOneMode;
		long operandOneGPR;
		long operandTwoMode;
		long operandTwoGPR;
		
		long result = 0; //array for two values , the address and the value
		
		
		long opOneAddress;
		long opOneValue;
		long opTwoAdress;
		long opTwoValue;
		
		
		long opcode;
		long remainder;
		
		final long[] errorFileOpen = new long[1];	
		errorFileOpen[0] = -1;
		
		final long[] invalidGPR = new long[1];
		invalidGPR[0] = -1;
		
		
		final long[] invalidOpCode = new long[1];
		invalidOpCode[0] = -1;
		
		final long[] invalidMode = new long[1];
		invalidMode[0] = -1;
		
		final long[] invalidRange = new long[1];
		invalidRange[0] = -1;
		
		final long[] halt = new long[1];
		halt[0] = -1;
		
		final long[] fetchOperandError = new long[1];
		fetchOperandError[0] = -1;
		
		final long[] error = new long[1];
		error[0] = -1;
		
		int notHalt = 0;
		
		boolean haltForWhile = true;
		boolean errorForWhile = true;
		
		
		long status[] = null;
		
		//long variableAddress[] = new long[2]; //to replace the operand address and operand value
		
		while(haltForWhile && errorForWhile) {
			
			//FetchCycle
			if((0 <= PC) && (PC <= 2500)) {
				
				
				MAR = PC;
				PC++;
				
				MBR = Memory[(int)MAR];
				
				
			}
			else {
				
				System.out.println("Error Test\n"); //giving error , there MUST be error
				return errorFileOpen;
				
			}
			
			IR[0] = MBR;
			
			
			//DecodeCycle
			opcode = IR[0] /10000;
			remainder = IR[0] % 10000;
			
			operandOneMode = remainder / 1000;
			remainder = remainder % 1000;
			
			operandOneGPR = remainder / 100;
			remainder = remainder % 100;
			
			operandTwoMode = remainder / 10;
			remainder = remainder % 10;
			
			operandTwoGPR = remainder;
			
			if(operandOneMode < 0 && operandOneMode > 7) {
				System.out.println("Invalid Mode...");
				return invalidMode;
			}
			
			if(operandTwoMode < 0 && operandTwoMode > 7) {
				System.out.println("Invalid Mode...");
				return invalidMode;
			}
			
			if(operandOneGPR < 0 && operandOneGPR > 8) {
				System.out.println("Invalid GPR...");
				return invalidGPR;
			}
			
			if(operandTwoGPR < 0 && operandTwoGPR > 8) {
				System.out.println("Invalid GPR...");
				return invalidGPR;
			}
			
			
			
			//execute cycle
			
			switch((int)opcode) {
			
			case 0: //halt
				System.out.println("Halt instruction is encountered...");
				return halt;
				
			case 1: //add
				
				status = FetchOperand(operandOneMode, operandOneGPR);
		
				opOneAddress = status[0];
				opOneValue = status[1];
			
				
				if (status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}
				
				status = FetchOperand(operandTwoMode, operandTwoGPR);
				
				
				opTwoAdress = status[0];
				opTwoValue = status[1];
			
				
				if(status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}	
				
				result = opOneValue + opTwoValue;
				
				
				
				opOneAddress = result;
				
				
				
				if(operandOneMode == 1) {
					
					GPR[(int)operandOneGPR] = result;
					
					
				}
				else if(operandOneMode == 6) {
					System.out.println("Error, destination operand connot be immediate mode...");
					return invalidMode;
				}
				else {
					
					Memory[(int)opOneAddress] = result;
				
				}
				
				clock += 3 ; //clock increments by add instruction time
				break;
				
			case 2: //subtract
				
				status = FetchOperand(operandOneMode, operandOneGPR);
				
				opOneAddress = status[0];
				opOneValue = status[1];
			
				
				if (status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}
				
				status = FetchOperand(operandTwoMode, operandTwoGPR);
				
				
				opTwoAdress = status[0];
				opTwoValue = status[1];
				
				
			
				
				if(status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}	
				
				result = opOneValue - opTwoValue;
				
				
				
				opOneAddress = result;
				
				
				
				if(operandOneMode == 1) {
					
					GPR[(int)operandOneGPR] = result;
					
					
				}
				else if(operandOneMode == 6) {
					System.out.println("Error, destination operand connot be immediate mode...");
					return invalidMode;
				}
				else {
					
					Memory[(int)opOneAddress] = result;
				
				}
				
				clock += 3 ; //clock increments by add instruction time
				break;
				
			case 3:	//multiply
				
				status = FetchOperand(operandOneMode, operandOneGPR);
				
				opOneAddress = status[0];
				opOneValue = status[1];
			
				
				if (status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}
				
				status = FetchOperand(operandTwoMode, operandTwoGPR);
				
				
				opTwoAdress = status[0];
				opTwoValue = status[1];
				
				
			
				
				if(status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}	
				
				result = opOneValue * opTwoValue;
				
				
				
				opOneAddress = result;
				
				
				
				if(operandOneMode == 1) {
					
					GPR[(int)operandOneGPR] = result;
					
					
				}
				else if(operandOneMode == 6) {
					System.out.println("Error, destination operand connot be immediate mode...");
					return invalidMode;
				}
				else {
					
					Memory[(int)opOneAddress] = result;
				
				}
				
				clock += 6 ; //clock increments by add instruction time
				break;
				
			case 4: //divide
				
				status = FetchOperand(operandOneMode, operandOneGPR);
				
				opOneAddress = status[0];
				opOneValue = status[1];
			
				
				if (status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}
				
				status = FetchOperand(operandTwoMode, operandTwoGPR);
				
				
				opTwoAdress = status[0];
				opTwoValue = status[1];
				
				
			
				
				if(status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}	
				
				if(opTwoValue == 0) {
					System.out.println("Fatal run-error, division by zero...");
					return error;
				}
				else {
					result = opOneValue / opTwoValue;
				}
				
				
				opOneAddress = result;
				
				
				
				if(operandOneMode == 1) {
					
					GPR[(int)operandOneGPR] = result;
					
					
				}
				else if(operandOneMode == 6) {
					System.out.println("Error, destination operand connot be immediate mode...");
					return invalidMode;
				}
				else {
					
					Memory[(int)opOneAddress] = result;
				
				}
				
				clock += 6 ; //clock increments by add instruction time
				break;
				
			case 5: //move
				
				status = FetchOperand(operandOneMode, operandOneGPR);
				
				opOneAddress = status[0];
				opOneValue = status[1];
			
				
				if (status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}
				
				status = FetchOperand(operandTwoMode, operandTwoGPR);
				
				
				opTwoAdress = status[0];
				opTwoValue = status[1];
				
				
			
				
				if(status[0] <= fetchOperandError[0]) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}	
				
				
				if(operandOneMode == 1) {
					
					GPR[(int)operandOneGPR] = result;
					
					
				}
				else if(operandOneMode == 6) {
					System.out.println("Error, destination operand connot be immediate mode...");
					return invalidMode;
				}
				else {
					
					Memory[(int)opOneAddress] = opTwoValue;
				
				}
				
				clock += 2 ; //clock increments by add instruction time
				break;
				
			case 6: //branch or jump
				
				if(PC != invalidRange[0]) {
					PC = Memory[(int)PC];
				}else {
					System.out.println("Error, run-time error code...");
					return error;
				}
				
				clock += 2;
				
			case 7: //branch on minus
				
				status = FetchOperand(operandOneMode, operandOneGPR);
				
				opOneAddress = status[0];
				opOneValue = status[1];
				
				if(opOneValue < 0) {
					
					if(PC != invalidRange[0]) {
						PC = Memory[(int)PC];
					}else {
						System.out.println("Error, run-time error code...");
						return error;
					}
				}else {
					PC++;
				}
				
				clock += 4;
				break;
				
			case 8: //branch on plus
				
				status = FetchOperand(operandOneMode, operandOneGPR);
				
				opOneAddress = status[0];
				opOneValue = status[1];
				
				if(opOneValue > 0) {
					
					if(PC != invalidRange[0]) {
						PC = Memory[(int)PC];
					}else {
						System.out.println("Error, run-time error code...");
						return error;
					}
				}else {
					PC++;
				}
				
				clock += 4;
				break;
				
			case 9: //branch on zero
				
				status = FetchOperand(operandOneMode, operandOneGPR);
				
				opOneAddress = status[0];
				opOneValue = status[1];
				
				if(opOneValue == 0) {
					
					if(PC != invalidRange[0]) {
						PC = Memory[(int)PC];
					}else {
						System.out.println("Error, run-time error code...");
						return error;
					}
				}else {
					PC++;
				}
				
				clock += 4;
				break;
				
		/*	case 10: //push
				
				status = FetchOperand(operandOneMode, operandOneGPR);
				
				opOneAddress = status[0];
				opOneValue = status[1];
			
				
				if (status[0] == fetchOperandError) {
					System.out.println("Invalid operand...");
					return fetchOperandError;
				}
				
				if(SP )
				
			case 11: //pop
			
			case 12: //system call
			
			
				
		*/
				
				default: 
					System.out.println("Invalid operand error...");
					return invalidOpCode;
				
			}//end of switch			
			
		}//end of while loop
		
		long[] returningValues = new long[2];
		
		returningValues[0] = status[0];
		returningValues[1] = status[1];
		
		return returningValues;
		
		
	}//End of CPU
	
	public static long[] FetchOperand(long operandMode, long operandRegister) {
		

		long opAddress;
		long opValue;
		long[] returningValues = new long[2];
		
		final long invAddress = -1;
		final long invRange = -1;
		
	//	long[] error1 = new long[1];
	//	errors[0] = invalidAddress;
	//	errors[1] = invalidRange;
		
	
		long[] invalidAddress = new long[1];
		invalidAddress[0] = invAddress;
		
		long[] invalidRange = new long[1];
		invalidRange[0] = invRange;
		
		
		
		
		
		switch((int)operandMode) {
		
		case 1: //register mode
			opAddress = invalidAddress[0];
			opValue = GPR[(int)operandRegister];
			break;
			
		case 2: //register deferred mode , operand address is in the register
			opAddress = GPR[(int)operandRegister];
			if(opAddress > invalidRange[0]) {
				
				opValue = Memory[(int)opAddress];
				
			}
			else {
				
				System.out.println("Error, invalid address...");
				return invalidAddress;
				
			}
			break;
			
		case 3: //autoincrement mode
			
			opAddress = GPR[(int)operandRegister];
			
			if(opAddress > invalidRange[0]) {
				
				opValue = Memory[(int)opAddress];
				
			}else {
				
				System.out.println("Error, invalid address...");
				return invalidAddress;
				
			}
			
			GPR[(int)operandRegister]++;
			
			break;
		
		case 4: //autodecrement mode
			
			--GPR[(int)operandRegister];
			
			opAddress = GPR[(int)operandRegister];
			
			if(opAddress > invalidRange[0]) {
				
				opValue = Memory[(int)opAddress];
				
				
			}else {
				
				System.out.println("Error, invalid address...");
				return invalidAddress;
				
			}
			break;
		
		case 5: //direct mode
			
			opAddress = Memory[(int)PC++];
			
			if(opAddress > invalidRange[0]) {
				
				opValue = Memory[(int)opAddress];
				
			}else {
				
				System.out.println("Error, invalid address...");
				return invalidAddress;
				
			}
			break;
			
		case 6: //immediate mode
			
			opAddress = invalidAddress[0];
			opValue = Memory[(int)PC++];
			break;
			
		default: //invalid mode
			System.out.println("Error, invalid address...");
			return invalidAddress;
			//break;
				
		} //end of switch
		
		returningValues[0] = opAddress;
		returningValues[1] = opValue;
		
		return returningValues;
		
		
		
		
	}
	
	public static void DumpMemory(String parameter, long startAddress, long size) {
		
		final int invalid = -1;
		final int error = -1;
		
		startAddress = 0;
		
		System.out.println(parameter);
		
		if(startAddress <= invalid) {
			
			System.out.println("Error, invalid start address...");
		}
			
		if (size <= invalid) {
			
			System.out.println("Error, invalid start address...");
		
		}

		System.out.println("GPRS:        \t  G0\tG1\tG2\tG3\tG4\tG5\tG6\tG7\tG8\tG9");
		
		System.out.println("             \t  " + GPR[0] + "\t " + GPR[1] + "\t " + GPR[2] + "\t "+ GPR [3] + "\t " + GPR[4] + "\t "+ GPR[5] + "\t " + GPR[6] + "\t " + GPR[7] + "\t " + SP + "\t" +PC);
		
		System.out.print("Address:     \t  +0\t+1\t+2\t+3\t+4\t+5\t+6\t+7\t+8\t+9");
		
		long addr = startAddress;
		long endAddress = startAddress + size;
		
		while(addr < endAddress) {
			
			System.out.println();
			System.out.print("Value of address: " + addr);
		
			
			
			for(int i = 0; i < 10; i++) {
				
				if(addr < endAddress) {
					
					System.out.print("\t" + Memory[(int)addr++]);
					
				}else {
					
					break; //no more value to print, exit for loop
					
				} 
				
			} //end of for loop
			
			
		}//end of while loop
		
		System.out.println();
		System.out.println("Clock value: " + clock + "\nPSR value: " + PSR);
		
			}// end of Dump Memory
	
	public static void main(String[] flex) throws IOException {
		
		programMain();
		
	}
	
}