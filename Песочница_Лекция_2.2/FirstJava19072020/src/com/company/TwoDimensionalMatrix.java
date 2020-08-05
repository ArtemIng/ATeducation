package com.company;

public class TwoDimensionalMatrix implements Matrix {

    private int[][] mass;
    private int lenghtMatrix;

    public int getLenghtMatrix() {
        return lenghtMatrix;
    }

    public TwoDimensionalMatrix(){
        lenghtMatrix = (int)(Math.random()*10)+1;
        generateMatrix();
    }

    public TwoDimensionalMatrix(int lenghtMatrix){
        this.lenghtMatrix = lenghtMatrix;
        generateMatrix();
    }

    private void generateMatrix(){
        mass = new int[lenghtMatrix][lenghtMatrix];
        for(int i=0;i<lenghtMatrix;i++){
            for(int j=0;j<lenghtMatrix;j++){
                mass[i][j]= (int)(Math.random()*10);
            }
        }
    }

    @Override
    public void printMatrix() {
        for (int i = 0; i < lenghtMatrix; i++) {
            for (int j = 0; j < lenghtMatrix; j++) {
                System.out.print(mass[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public int countElementMatrix() {
        return lenghtMatrix*lenghtMatrix;
    }
}
