import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Mina extends JButton{
	public final int L;
	public final int C;
	public boolean isBomba;
	public Mina[] perimetro = {null, null, null, null, null, null, null, null};
	public Mina(int l, int c) {
		L = l;
		C = c;
		isBomba = getRandom(2)==1?true:false;
	}
	private int getRandom(int n) {
		Random r = new Random();
		return Math.abs(r.nextInt())%n;
	}
	public Collection<Mina> perimetros(){
		Collection<Mina> minas = new ArrayList<>();
		for(int i=0;i<perimetro.length;i++)
			if(perimetro[i]!=null)
				minas.add(perimetro[i]);
		return minas;
	}
	public void setPerimetro(Mina[][] minas) {
		int len = minas.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				//Linha anterior
				if(L-1==L-i && C-1==C-j) {
					if((L-1)>=0 && (C-1)>=0)
						perimetro[0] = minas[L-i][C-j];
				} 
				if(L-1==L-i && C==j) {
					if((L-1)>=0)
						perimetro[1] = minas[L-i][j];
				} 
				if(L-1==L-i && C+1==C+j) {
					if((L-1)>=0 && (C+1)<len)
						perimetro[2] = minas[L-i][C+j];
				} 
				//Linha igual
				if(L==i && C-1==C-j) {
					if((C-1)>=0)
						perimetro[3] = minas[i][C-j];
				} 
				if(L==i && C+1==C+j) {
					if((C+1)<len)
						perimetro[4] = minas[i][C+j];
				} 
				//Linha posterior
				if(L+1==L+i && C-1==C-j) { 
					if((L+1)<len && (C-1)>=0)
						perimetro[5] = minas[L+i][C-j];
				} 
				if(L+1==L+i && C==j) {
					if((L+1)<len)
						perimetro[6] = minas[L+i][j];
				} 
				if(L+1==L+i && C+1==C+j) {
					if((L+1)<len && (C+1)<len)
						perimetro[7] = minas[L+i][C+j];
				}
			}
		}
	}
}
