package testing.DrawLineTest;

import engine.GameObject;
import engine.Scene;
import engine.Script;
import engine.graphics.ImageAlgorithms3D;
import engine.math.FinalVector;
import engine.utils.Screen;

import static engine.utils.MathUtils.*;

import engine.Engine;

public class DrawLineEngineTest 
{
    public static void main(String[] args)
    {
        Engine engine = new Engine(Screen.get(0), vec(1080, 720), 40, 40, "main");

        engine.setActiveScene(new LineTestScene());

        engine.activate();
    }    

    public static class LineTestScene extends Scene
    {
        @Override
        protected void init() 
        {
            GameObject gameObject = new GameObject();
            addGameObject(gameObject);
            
            gameObject.addScript(new LineTestScript());

            gameObject.scripts()[0].activate();
            gameObject.activate();

        }
    }

    public static class LineTestScript extends Script
    {
        @Override protected void start() { setActive(true); a = b = fvec(0, 0); }

        private FinalVector a;
        private FinalVector b;

        @Override
        protected void update() 
        {
            if (left().isDown())
                a = mouse().position();
            if (right().isDown())
                b = mouse().position();    
        }

        @Override
        protected void render() 
        {
            ImageAlgorithms3D.renderTestMeshWithTestImage(image());
            image().line(a, b, 30, 40, 0xff00ff00);    
        }
    }
}
