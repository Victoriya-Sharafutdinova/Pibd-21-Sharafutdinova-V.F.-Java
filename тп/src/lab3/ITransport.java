package lab3;

import java.awt.Graphics;

public interface ITransport {
	void SetPosition(int x, int y, int width, int height);
    void MoveTransport(Direction direction);
    void DrawShip(Graphics g);
    void setMainColor(String colorName);
    String getInfo();
}
