
public abstract class ImagemAnimada extends Imagem implements Runnable {

	public void run() {
		  while(true) {
		    this.setX(this.getX() + 10);
		    if(getX() > 1350){
				this.setX(0);
				this.setY(this.getY()+60);
			}
			if(getY() > 750){
				this.setX(0);
				this.setY(30);
			}
		    try {
		
		Thread.sleep(3000);
		    } catch (InterruptedException e) {
		e.printStackTrace();
		    }
		  }
		}	

}

