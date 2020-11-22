% John Luke Denny
% CSC 2262
% cs226224
% Lab 5a

%Graphs the solutions to three differential equations

t = 0: .001: 80;
u0 = [1000, 500, 600];
options = odeset('RelTol',1e-7,'AbsTol',1e-7);
[t, u] = ode45('gilpin',t,u0,options);

plot(t,u(:,1),'b',t,u(:,2),'g',t,u(:,3),'r');

axis([0 80 -100 1100]);

set(gca,'xtick',0: 10: 80);

set(gca,'ytick',-100:100:1100);

xlabel('t');

ylabel('X(blue), Y(green), Z(red) Populations');

title('Lab 5a');

