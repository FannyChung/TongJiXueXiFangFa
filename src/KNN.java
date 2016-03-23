

/**
 * 
 */

/**
 * @author fang
 *
 */
public class KNN {

	/**
	 * 
	 */
	public KNN() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param p 范数 =1为曼哈顿；=2为欧式
	 * @param x1 第一个点
	 * @param x2  第二个点
	 * @return 两个点的p范数距离
	 */
	public double  distance(int p,Point x1,Point x2){
		double distance=0;
		for (int i = 0; i < x1.getX().size(); i++) {
			double x1l = x1.getX().get(i);
			double x2l= x2.getX().get(i);
			distance+=Math.pow(Math.abs(x1l-x2l), p);
		}
		double ppp=(double)1/p;
		distance=Math.pow(distance, ppp);
		return distance;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p1=new Point(new double[]{1,1});
		Point p2=new Point(new double[]{5,1});
		Point p3=new Point(new double[]{4,4});
		KNN knn=new KNN();
		
		for (int p = 1; p < 10; p++) {
			System.out.println(p);
			System.out.println("p2\t"+knn.distance(p, p1, p2));
			System.out.println("p3\t"+knn.distance(p, p1, p3));
			System.out.println();
		}
	}

}
