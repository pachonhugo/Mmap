package Mmap;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;

/**
 *
 * @author hugoa
 */
public class Dibujo extends Canvas implements MouseListener, MouseMotionListener{
    
    private ArrayList rectangles= new ArrayList();
    private ArrayList cicles= new ArrayList();
    private ArrayList shapes= new ArrayList();
    public Color color;
    public int strk_width;
    private Path2D shape;
    public boolean m_alzada=true, rectangle=false, circle=false;
    private int x0,y0,x,y;
    
    Dibujo(){
        this.color=Color.black;
        this.setBackground(Color.white);
        this.shape=new Path2D.Float();
        this.strk_width=5;
    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D draw=(Graphics2D) g;
        draw.setColor(Color.white);
        draw.fillRect(0, 0, this.getWidth(), this.getHeight());
        draw.setStroke(new BasicStroke(this.strk_width));
        draw.setColor(this.color);
        draw.draw(this.shape);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.m_alzada) this.shape.moveTo(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.x= e.getX();
        this.y= e.getY();
        if(this.m_alzada) this.shape.lineTo(this.x, this.y);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
