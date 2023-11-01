import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Principal extends JFrame
	implements MouseMotionListener {
	
	
	private static final long serialVersionUID = 1L;
	private ImagemMovida carro;
	private Imagem fundo;
	private Imagem nuvem;
	private Imagem clouds;
	private Imagem mouseposicao;
	private AnimaFoguete foguete;
	
	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseMotionListener(this);
		fundo = new Imagem();
		fundo.setX(0);
		fundo.setY(0);
		fundo.setImg("fundo.jpg");
		
		foguete = new AnimaFoguete();
		foguete.setX(0);
		foguete.setY(90);
		foguete.setImg("foguete.png");
		
		carro = new ImagemMovida();
		carro.setX(50);
		carro.setY(300);
		carro.setImg("carroazul.png");
		
		nuvem = new Imagem();
		nuvem.setX(100);
		nuvem.setY(40);
		nuvem.setImg("nuvem.png");
		
		clouds = new Imagem();
		clouds.setX(10);
		clouds.setY(90);
		clouds.setImg("clouds.png");
		
		mouseposicao = new Imagem();
		
	}
	
	//ESSE EH O METODO QUE DEVE SER ADAPTADO AO PROJETO
	public void renderizarImagens(Graphics g2) {
		//Desenhando as imagens
		
		fundo.desenhar(g2);
		carro.desenhar(g2);
		nuvem.desenhar(g2);
		clouds.desenhar(g2);
		foguete.desenhar(g2);
		//TESTE para lançar o foguete
		Thread lancar = new Thread(foguete);
		lancar.start();
		
		
	}
	

	
	//EVITAR ALTERAR ESSE METODO
	public static void main(String[] args) {
		//Criando uma instancia da classe principal
		Principal t = new Principal();
		t.setSize(1300, 750);
		t.createBufferStrategy(1);		
		t.setVisible(true);
		t.createBufferStrategy(2);
	}
	
	//EVITAR ALTERAR ESSE METODO
	public void renderizarGraphics() {
		if (!getBufferStrategy().contentsLost()) getBufferStrategy().show();
	    Graphics g = getBufferStrategy().getDrawGraphics();
	    //Criando um contexto grafico
	    Graphics g2 = g.create();
	    //Limpando a tela
	    g2.setColor(Color.BLACK);        
	    g2.fillRect(0, 0, getWidth(), getHeight());
	    renderizarImagens(g2);
	    //Liberando os contextos criados
	    g.dispose(); 
	    g2.dispose();
	}
	
	//EVITAR ALTERAR ESSE METODO
	public void paint(Graphics g) {
		this.renderizarGraphics();
		repaint();
		if (nuvem.getX() > 1350) {
			nuvem.setX(-30);
		}else {
			nuvem.setX(nuvem.getX()+1);
		}
		
		if (clouds.getX() > 1350) {
			clouds.setX(-30);
		}else {
			clouds.setX(clouds.getX()+2);
		}
		
		if(mouseposicao.getX() > carro.getX()) {
			carro.moverDireita(2);			
		}
		else {
			carro.moverEsquerda(2);			
		}
		
		if(mouseposicao.getY() > carro.getY()) {
			carro.moverBaixo(2);			
		}
		else {
			carro.moverCima(2);			
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("[" + e.getX() + ";" + e.getY() + "]");
		mouseposicao.setX(e.getX());
		mouseposicao.setY(e.getY());
	/*	if(e.getX() > carro.getX()) {
			carro.moverDireita(1);			
		}
		else {
			carro.moverEsquerda(1);			
		}
		
		if(e.getY() > carro.getY()) {
			carro.moverBaixo(1);			
		}
		else {
			carro.moverCima(1);			
		}*/
	}
}