package core;


import java.util.Arrays;

public class RAM {
    private byte memory[] = new byte[65536];

    public byte getValue(char address){
        return memory[address];
    }

    public char getAValue(char address){
        return (char)(((char)memory[address] << 8) | (char) memory[(char)(address + 1)]);
    }

    public void storeValue(byte value, char address){
        memory[address] = value;
    }

    public void storeAValue(char aValue, char address){
        memory[address] = (byte)(aValue >> 8);
        memory[address+1] = (byte)(aValue);
    }

    public void reset()
    {
        this.memory = new byte[65536];
    }

    public void loadProgram(byte[] program){
        if(program == null)
            return;
        System.arraycopy(program, 0, memory, 0, program.length);
    }
}
