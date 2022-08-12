package coordinateSystem;

public class Transform {
	public static float[] transform3x3(float x, float y,float[][] matrix) {
		float[] ret=new float[3];
		ret[0]=x*matrix[0][0]+y*matrix[1][0]+matrix[2][0];
		ret[1]=x*matrix[0][1]+y*matrix[1][1]+matrix[2][1];
		ret[2]=x*matrix[0][2]+y*matrix[1][2]+matrix[2][2];
		
		return ret;
	}
	public static float[][] multi3x3(float[][] matrix1,float[][] matrix2) {
		float[][] ret=new float[3][3];
		   for(int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                for (int k = 0; k < 3; k++) {
	                    ret[i][j] += matrix1[i][k] * matrix2[k][j];
	                }
	            }
	        }
		
		return ret;
	}
	
	public static float[] transform4x4(float x, float y,float z,float[][] matrix) {
		float[] ret=new float[4];
		ret[0]=x*matrix[0][0]+y*matrix[1][0]+z*matrix[2][0]+matrix[3][0];
		ret[1]=x*matrix[0][1]+y*matrix[1][1]+z*matrix[2][1]+matrix[3][1];
		ret[2]=x*matrix[0][2]+y*matrix[1][2]+z*matrix[2][2]+matrix[3][2];
		ret[3]=x*matrix[0][3]+y*matrix[1][3]+z*matrix[2][3]+matrix[3][3];
		
		return ret;
	}
	public static float[][] multi4x4(float[][] matrix1,float[][] matrix2) {
		float[][] ret=new float[4][4];
		   for(int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                for (int k = 0; k < 4; k++) {
	                    ret[i][j] += matrix1[i][k] * matrix2[k][j];
	                }
	            }
	        }
		
		return ret;
	}
}
