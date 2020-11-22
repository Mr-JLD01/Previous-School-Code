% John Luke Denny
% CSC 2262
% cs226224
% Lab 5b
%Calculates and graphs the positions and velocities of a damped spring
%system

t = 0:.001:6;
u0 = [.6 0 .4 0 .7 0 .8 0 .5 0 .2 0 .3 0];
options = odeset('RelTol',1e-7,'AbsTol',1e-7);

[t u] = ode45('dampSpring',t,u0,options);

line1x = [0 6];
line1y = [0 0];

figure(1);

plot(t,u(:,1),'y',t,u(:,3),'r',t,u(:,5),'g',t,u(:,7),'b',t,u(:,9),'m',t,u(:,11),'k',t,u(:,13),'c',line1x,line1y,'k');
axis([0 6 -.8 1]);

set(gca,'xtick',0:6);
set(gca,'ytick',-.8: .2: 1);

xlabel('t');
ylabel('x1(y), x2(r), x3(g), x4(b), x5(m), x6(k), x7(c)');

title('Lab 5b, Figure 1');

figure(2);

plot(t,u(:,2),'y',t,u(:,4),'r',t,u(:,6),'g',t,u(:,8),'b',t,u(:,10),'m',t,u(:,12),'k',t,u(:,14),'c',line1x,line1y,'k');
axis([0 6 -1.8 1]);

set(gca,'xtick',0:6);
set(gca,'ytick',-1.8: .2: 1);

xlabel('t');
ylabel('v1(y), v2(r), v3(g), v4(b), v5(m), v6(k), v7(c)');

title('Lab 5b, Figure 2');