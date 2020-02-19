%John Luke Denny
%CSC 2262
%cs226224
%Lab 3

%calculates and graphs a robotic arm of two parts with three unknown angles
%2/11/2020

degToRad = pi /180;

R1 = 2.4;
R2 = 2.2;

X = 2.67;
Y = 1.5;

guess1 = 20 * degToRad;
guess2 = 70 * degToRad;
guessPhi = 30 * degToRad;
accuracy = 1e-7;

count = 0;
for(z = 0: .01 :2.5)
    Z = z;
    count = count +1;
    f1 = @(t1,t2,phi) R1*sin(t1)*cos(phi) + R2*sin(t1 + t2)*cos(phi) - X;
    f2 = @(t1,t2,phi) R1*sin(t1)*sin(phi) + R2*sin(t1 + t2)*sin(phi) - Y;
    f3 = @(t1,t2,phi) R1*cos(t1) + R2*cos(t1 + t2) - Z;

    df1dt1 = @(t1,t2,phi) R1*cos(t1)*cos(phi) + R2*cos(t1 + t2)*cos(phi);
    df1dt2 = @(t1,t2,phi) R2*cos(t1 + t2)*cos(phi);
    df1dtPhi = @(t1,t2,phi) -R1*sin(t1)*sin(phi) - R2*sin(t1 + t2)*sin(phi);

    df2dt1 = @(t1,t2,phi) R1*cos(t1)*sin(phi) + R2*cos(t1 + t2)*sin(phi);
    df2dt2 = @(t1,t2,phi) R2*cos(t1 + t2)*sin(phi);
    df2dtPhi = @(t1,t2,phi) R1*sin(t1)*cos(phi) + R2*sin(t1 + t2)*cos(phi);
    
    df3dt1 = @(t1,t2,phi) -R1*sin(t1) - R2*sin(t1 + t2);
    df3dt2 = @(t1,t2,phi) -R2*sin(t1 + t2);
    df3dtPhi = @(t1,t2,phi) 0;

    [t1, t2, phi] = newton3(f1,f2,f3,df1dt1,df1dt2,df1dtPhi,df2dt1,df2dt2,df2dtPhi,df3dt1,df3dt2,df3dtPhi,guess1,guess2,guessPhi,accuracy);
    
    R1h = R1*sin(t1);
    R1x = R1h*cos(phi);
    R1y = R1h*sin(phi);
    R1z = R1*cos(t1);
    
    R2h = R2*sin(t1 + t2);
    R2x = R2h*cos(phi);
    R2y = R2h*sin(phi);
    R2z = R2*cos(t1 + t2);

    line1x = [0, R1x];
    line1y = [0, R1y];
    line1z = [0, R1z];

    line2x = [R1x, R1x + R2x];
    line2y = [R1y, R1y + R2y];
    line2z = [R1z, R1z + R2z];
    
    
    plot3(line1x,line1y,line1z,'r',line2x,line2y,line2z,'b', X,Y,Z,'ko');

    grid on;
    box on;

    axis([ 0 3 0 3 0 3]);

    set(gca,'xtick', 0 : 1 : 3);
    set(gca,'ytick', 0 : 1 : 3);
    set(gca,'ztick', 0 : 1 : 3);
    
    pbaspect([1 1 1]);

    xlabel('x');
    ylabel('y');  
    zlabel('z');

    title('Lab 3');
    
    
    
    pause(.01);
    if(count == 1)
        pause(8);
    end
end