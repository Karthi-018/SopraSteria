package edu.assign;

public class Main_pojo {
	
	    private int pid;
	    private String pname;
	    private int cost;
	    
	    
	    public Main_pojo(int pid, String pname, int cost) {
			this.pid = pid;
			this.pname = pname;
			this.cost = cost;
		}

		public int getPid() {
			return pid;
		}

		public void setPid(int pid) {
			this.pid = pid;
		}

		public String getPname() {
			return pname;
		}

		public void setPname(String pname) {
			this.pname = pname;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Main_pojo [pid=" + pid + ", pname=" + pname + ", cost=" + cost + "]";
		}
}
