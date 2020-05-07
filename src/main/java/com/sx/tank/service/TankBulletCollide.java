package com.sx.tank.service;

import com.sx.tank.model.AbstractGameObject;
import com.sx.tank.model.Bullet;
import com.sx.tank.model.Player;
import com.sx.tank.model.Tank;

public class TankBulletCollide implements Collide {
    @Override
    public boolean collide(AbstractGameObject o1, AbstractGameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Bullet) {
            Tank t1 = (Tank) o1;
            Bullet b1 = (Bullet) o2;
            System.out.println(t1.getGroup() + "==" + t1.getGroup());
            if (!t1.isLive() || !b1.isLive()) {
                return true;
            }
            if (t1.getGroup() == b1.getGroup()) {
                return true;
            }
            if (b1.getRect().intersects(t1.getRect())) {
                t1.die();
                b1.die();
            }
        }else if(o2 instanceof Tank && o1 instanceof Bullet) {
            return collide(o2, o1);
        }
        return false;
    }
}
