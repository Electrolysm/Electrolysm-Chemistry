package chemistry.electrolysm.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBunsenBurner extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Tube;
    ModelRenderer leg;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer support;
    ModelRenderer support1;
    ModelRenderer support2;
    ModelRenderer testTube;
  
  public ModelBunsenBurner()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 8, 1, 8);
      Base.setRotationPoint(-4F, 23F, -4F);
      Base.setTextureSize(64, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Tube = new ModelRenderer(this, 40, 0);
      Tube.addBox(0F, 0F, 0F, 2, 10, 2);
      Tube.setRotationPoint(-1F, 13F, -1F);
      Tube.setTextureSize(64, 32);
      Tube.mirror = true;
      setRotation(Tube, 0F, 0F, 0F);
      leg = new ModelRenderer(this, 0, 10);
      leg.addBox(0F, 0F, 0F, 1, 18, 1);
      leg.setRotationPoint(-5F, 6F, -0.5F);
      leg.setTextureSize(64, 32);
      leg.mirror = true;
      setRotation(leg, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 10);
      leg1.addBox(0F, 0F, 0F, 1, 18, 1);
      leg1.setRotationPoint(4F, 6F, 3F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 10);
      leg2.addBox(0F, 0F, 0F, 1, 18, 1);
      leg2.setRotationPoint(4F, 6F, -4F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      support = new ModelRenderer(this, 5, 10);
      support.addBox(0F, 0F, 0F, 9, 1, 1);
      support.setRotationPoint(-4F, 6F, 0F);
      support.setTextureSize(64, 32);
      support.mirror = true;
      setRotation(support, 0F, -0.3578235F, 0.0174533F);
      support1 = new ModelRenderer(this, 5, 10);
      support1.addBox(0F, 0F, 0F, 9, 1, 1);
      support1.setRotationPoint(-4.3F, 6F, -1F);
      support1.setTextureSize(64, 32);
      support1.mirror = true;
      setRotation(support1, 0F, 0.3578274F, 0.0174533F);
      support2 = new ModelRenderer(this, 5, 14);
      support2.addBox(0F, 0F, 0F, 1, 1, 7);
      support2.setRotationPoint(3F, 6F, -3.5F);
      support2.setTextureSize(64, 32);
      support2.mirror = true;
      setRotation(support2, 0F, 0F, 0F);
      testTube = new ModelRenderer(this, 23, 13);
      testTube.addBox(0F, 0F, 0F, 2, 10, 2);
      testTube.setRotationPoint(-1F, 0F, -1F);
      testTube.setTextureSize(64, 32);
      testTube.mirror = true;
      setRotation(testTube, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Tube.render(f5);
  }

    public void renderTripod(float f5){
        leg.render(f5);
        leg1.render(f5);
        leg2.render(f5);
        support.render(f5);
        support1.render(f5);
        support2.render(f5);
    }

    public void renderTestTube(float f5){
        testTube.render(f5);
    }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
