% John Luke Denny
% CSC 2262
% cs226224
% Lab 6

%Calculates and graphs differential equations using eigenvectors and
%eigenvalues

t = 0: .001: 10;

m1 = .4;
m2 = .7;
m3 = .7;
m4 = .2;
m5 = .6;
m6 = .5;

k1 = 3.9;
k2 = 3.2;
k3 = 2.2;
k4 = 2.7;
k5 = 1.3;
k6 = 4.9;
k7 = 4.4;

A = [   -(k1 + k2)/m1   k2/m1           0               0               0               0;
        k2/m2           -(k2 + k3)/m2   k3/m2           0               0               0;
        0               k3/m3           -(k3 + k4)/m3   k4/m3           0               0;
        0               0               k4/m4           -(k4 + k5)/m4   k5/m4           0;
        0               0               0               k5/m5           -(k5 + k6)/m5   k6/m5;
        0               0               0               0               k6/m6           -(k6 + k7)/m6];
A = -A;
[eigvec, eigval] = eig(A);
linex = [0 10];
liney = [0 0];
titles(1, :) = 'Lab 6, Figure 1';
titles(2, :) = 'Lab 6, Figure 2';
titles(3, :) = 'Lab 6, Figure 3';
titles(4, :) = 'Lab 6, Figure 4';
titles(5, :) = 'Lab 6, Figure 5';
titles(6, :) = 'Lab 6, Figure 6';

for(k = 1:6)
    w = sqrt(eigval(k,k));
    
    c1 = eigvec(1,k);
    c2 = eigvec(2,k);
    c3 = eigvec(3,k);
    c4 = eigvec(4,k);
    c5 = eigvec(5,k);
    c6 = eigvec(6,k);
    
    x1 = c1*cos(w*t);
    x2 = c2*cos(w*t);
    x3 = c3*cos(w*t);
    x4 = c4*cos(w*t);
    x5 = c5*cos(w*t);
    x6 = c6*cos(w*t);
    
    c = [abs(c1), abs(c2), abs(c3), abs(c4), abs(c5), abs(c6)];
    [minAmp, maxAmp] = minMax(c);
    f = w / (2*pi);
    
    fprintf('Mode %1.0f:   Freqency = %.5f  Max Amplitude = %.5f  Min Amplitude = %.5f\n', k, f, maxAmp, minAmp);
    
    figure(k);
    plot(t,x1,'b', t,x2,'r',t,x3,'g', t,x4,'k',t,x5,'m', t,x6,'c',linex,liney,'k');
    axis([0 10 -1 1]);
    
    set(gca,'xtick',0:10);
    set(gca,'ytick',-1:.2:1);
    
    xlabel('t');
    ylabel('x1(blue), x2(red), x3(green), x4(black), x5(magenta), x6(cyan)');
    
    title(titles(k,:));
    
end

function [min, max] = minMax(array)  
    min = array(1);
    max = array(1);
    for(i = 2:6)
        if(min > array(i))
            min = array(i);
        elseif(max < array(i))
            max = array(i);
        end
    end
end