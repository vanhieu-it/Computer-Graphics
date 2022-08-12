package drawableObject;

import java.util.ArrayList;

import coordinateSystem.Transform;
import drawer.Drawer;
import mainPane.Frame;

public abstract class DrawableObject implements Drawable{
	protected float[][] tranformMatrix;
	protected ArrayList<float[][]> transformList;
//	protected ArrayList<Float> timeOut;
//	protected ArrayList<Float> beginTime;
//	protected ArrayList<Integer> tmpRemoveIndex;
	
	public DrawableObject() {
		tranformMatrix=new float[][] {
			{1,0,0},
			{0,1,0},
			{0,0,1}
		};
	}

	public  void drawSelf(Drawer drawer) {
		//Tranform
		
		if(transformList!=null) {
			for(int i=0;i<transformList.size();i++) {
				tranformMatrix=Transform.multi3x3(tranformMatrix, transformList.get(i));
//				if(beginTime.get(i)+timeOut.get(i)<=Frame.lastFrameTime/1e9) {
//					tmpRemoveIndex.add(i);
//				}
			}
			
			
//			int k=0;
//			for(int index: tmpRemoveIndex)
//			{
//				transformList.remove(index-k);
//				timeOut.remove(index-k);
//				beginTime.remove(index-k);
//				++k;
//			}
//			tmpRemoveIndex.clear();
			
		}
	}
	
	public void addTimelineTranform(float [][] matrix3x3) {
		if(transformList==null) {
			
			
			transformList=new ArrayList<float[][]>();
//			timeOut=new ArrayList<Float>();
//			beginTime=new ArrayList<Float>();
//			tmpRemoveIndex=new ArrayList<Integer>();
		}
		transformList.add(matrix3x3);
//		timeOut.add(time_out);
//		beginTime.add((float) (Frame.lastFrameTime/1e9));
	}
	
	public void clearTimelineTransform() {
		if(transformList!=null)
		transformList.clear();
	}
	
	public void removeTimelineTransform(int index) {
		if(transformList!=null)
		transformList.remove(index);
	}
	
	public void toOriginalTransform() {
		tranformMatrix=new float[][] {
			{1,0,0},
			{0,1,0},
			{0,0,1}
		};
	}
}
