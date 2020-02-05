%John Luke Denny
%CSC 2262
%cs226224
%Lab 2

%calculates and graphs a four bar linkage with one of the bars,driver,
%changing its angle
%2/4/2020

degToRad = pi /180;
radToDeg = 180 / pi;

R1 = 4.14;
R2 = 3.25;
R3 = 3.77;
R4 = 2.57;

guess2 = 75 * degToRad;
guess3 = 30 * degToRad;

accuracy = 1e-7;

count = 0;
for(theta4 = 84: 804)
    t4 = theta4 * degToRad; 
    count = count +1;
    f1 = @(t2,t3) R2 * cos(t2) + R3 * cos(t3) + R4 * cos(t4) - R1;

    f2 = @(t2,t3) R4 * sin(t4) + R3 * sin(t3) - R2 * sin(t2);

    df1dt2 = @(t2) -R2 * sin(t2);

    df1dt3 = @(t3) -R3 * sin(t3);

    df2dt2 = @(t2) -R2 * cos(t2);

    df2dt3 = @(t3) R3 * cos(t3);

    [t2, t3] = newton2(f1,f2,df1dt2,df1dt3,df2dt2,df2dt3,guess2,guess3,accuracy);
    
    R2x = R2*cos(t2);

    R2y = R2*sin(t2);
    
    R3x = R3*cos(t3);

    R3y = R3*sin(t3);
    
    R4x = R4*cos(t4);

    R4y = R4*sin(t4);

    line1x = [0, R1];

    line1y = [0, 0];

    line2x = [0, R2x];

    line2y = [0, R2y];
    
    line3x = [R2x, R2x + R3x];

    line3y = [R2y, R2y - R3y];

    line4x = [R1 - R4x, R1];

    line4y = [R4y, 0];

    plot(line1x,line1y,'k',line2x,line2y,'r',line3x,line3y,'g',line4x,line4y,'b');

    axis([ -3 7 -3 7]);

    set(gca,'xtick', -3 : 1 : 7);

    set(gca,'ytick', -3 : 1 : 7);

    pbaspect([1 1 1]);

    xlabel('x');

    ylabel('y');

    title('Lab 2');
    
    
    
    pause(.01);
    if(count == 1)
        pause(7);
    end
end